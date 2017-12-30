package com.panda.example.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.panda.example.consumer")
public class ConsumerProviderApplication {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerProviderApplication.class);

	public static void main(String[] args) throws IOException{
		SpringApplication.run(ConsumerProviderApplication.class, args);
		logger.info("service-consumer>>>>>>服务启动完成!");
	}



}
