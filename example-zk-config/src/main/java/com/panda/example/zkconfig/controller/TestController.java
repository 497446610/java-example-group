package com.panda.example.zkconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${url:default}")
	private String url;

	@RequestMapping("hello")
	public String hello() {
		return url;
	}

}
