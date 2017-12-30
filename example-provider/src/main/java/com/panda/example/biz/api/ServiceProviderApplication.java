package com.panda.example.biz.api;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.panda.example.dao.mapper")
@ComponentScan(basePackages="com.panda.example.biz.api")
public class ServiceProviderApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceProviderApplication.class);

	public static void main(String[] args) throws IOException{
		SpringApplication.run(ServiceProviderApplication.class, args);
		logger.info("service-provider>>>>>>服务启动完成!");
		System.in.read();
	}



}
