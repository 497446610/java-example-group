package com.panda.example.zkconfig.autoconfig;

import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class ZookeeperPropertySourceLocator implements PropertySourceLocator {
	private static final Log log = LogFactory.getLog(ZookeeperPropertySourceLocator.class);
	
	
	@Autowired(required=false)
	private ZookeeperProperties zookeeperProperties;
	
	@Override
	public PropertySource<?> locate(Environment environment) {
		
		if(zookeeperProperties == null) {
			log.info("未启用zk配置中心");
		}else {
			log.info("启用zk配置中心");
		}
		return new MapPropertySource("customProperty",
				Collections.<String, Object>singletonMap("url", "juest test url"));
	}

}
