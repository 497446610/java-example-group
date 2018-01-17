package com.github.kuangxf.zkconfig;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
		implements InitializingBean, DisposableBean {

	
	
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@Override
	protected void loadProperties(Properties prop) throws IOException {
		super.loadProperties(prop);
	}
	
}
