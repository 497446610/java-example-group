package com.panda.example.zkconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${url:default}")
	private String url;
	
	
	@Value("${zkServer:default}")
	private String zkServer;
	
	
	@Value("${spring.datasource.driverClassName:default}")
	private String datasource;

	@RequestMapping("hello")
	public String hello() {
		return url;
	}
	
	
	@RequestMapping("zkServer")
	public String zkServer() {
		return zkServer;
	}

	
	@RequestMapping("datasource")
	public String datasource() {
		return datasource;
	}

}
