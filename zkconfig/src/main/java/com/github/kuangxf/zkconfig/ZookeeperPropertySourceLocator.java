/*
 * Copyright 2013-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kuangxf.zkconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.util.ReflectionUtils;

public class ZookeeperPropertySourceLocator	{

	private ZookeeperConfigProperties properties;

	private CuratorFramework curator;

	private List<String> contexts;

	private static final Log log = LogFactory.getLog(ZookeeperPropertySourceLocator.class);

	public ZookeeperPropertySourceLocator(CuratorFramework curator, ZookeeperConfigProperties properties) {
		this.curator = curator;
		this.properties = properties;
	}

	public List<String> getContexts() {
		return this.contexts;
	}

	public PropertySource<?> locate(Environment environment) {
		if (environment instanceof ConfigurableEnvironment) {
			ConfigurableEnvironment env = (ConfigurableEnvironment) environment;
			String appName = env.getProperty("spring.application.name");
			if (appName == null) {
				// use default "application" (which config client does)
				appName = "application";
				log.warn("spring.application.name is not set. Using default of 'application'");
			}
			List<String> profiles = Arrays.asList(env.getActiveProfiles());

			String root = this.properties.getRoot();
			this.contexts = new ArrayList<>();

			String defaultContext = root + "/" + this.properties.getDefaultContext();
			this.contexts.add(defaultContext);
			addProfiles(this.contexts, defaultContext, profiles);

			StringBuilder baseContext = new StringBuilder(root);
			if (!appName.startsWith("/")) {
				baseContext.append("/");
			}
			baseContext.append(appName);
			this.contexts.add(baseContext.toString());
			addProfiles(this.contexts, baseContext.toString(), profiles);

			CompositePropertySource composite = new CompositePropertySource("zookeeper");

			Collections.reverse(this.contexts);

			for (String propertySourceContext : this.contexts) {
				try {
					PropertySource propertySource = create(propertySourceContext);
					composite.addPropertySource(propertySource);
				} catch (Exception e) {
					if (this.properties.isFailFast()) {
						ReflectionUtils.rethrowRuntimeException(e);
					} else {
						log.warn("Unable to load zookeeper config from " + propertySourceContext, e);
					}
				}
			}

			return composite;
		}
		return null;
	}

	@PreDestroy
	public void destroy() {
	}

	private PropertySource<CuratorFramework> create(String context) {
		return new ZookeeperPropertySource(context, this.curator);
	}

	private void addProfiles(List<String> contexts, String baseContext,
			List<String> profiles) {
		for (String profile : profiles) {
			contexts.add(baseContext + this.properties.getProfileSeparator() + profile);
		}
	}
}
