package com.panda.example.rmq.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.panda.example.rmq.consumer.config.RabbitProperties;

@SpringBootApplication
@EnableConfigurationProperties(RabbitProperties.class)
@ComponentScan(basePackages="com.panda.example.rmq.consumer")
public class ServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

	public static void main(String[] args) throws IOException{
		SpringApplication.run(ServiceApplication.class, args);
		logger.info("service-provider>>>>>>服务启动完成!");
		System.in.read();
	}



}
