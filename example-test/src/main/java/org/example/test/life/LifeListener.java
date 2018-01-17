package org.example.test.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifeListener implements BeanPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LifeListener.class);

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		//logger.info("---------------->postProcessAfterInitialization,class:{}", arg0.getClass().getName());
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		//logger.info("---------------->postProcessBeforeInitialization,class:{}", arg0.getClass().getName());
		return arg0;
	}

}
