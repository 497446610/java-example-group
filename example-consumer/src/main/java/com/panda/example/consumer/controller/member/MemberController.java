package com.panda.example.consumer.controller.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.example.biz.api.member.IMemberService;
import com.reger.dubbo.annotation.Inject;

@RestController
public class MemberController {

	@Inject
	IMemberService memberSerivce;

	@RequestMapping("/hello")
	public String sayHello(String name) {
		return memberSerivce.sayHello(name);
	}
	
	@RequestMapping("/cache")
	public String cache() {
		return memberSerivce.cacheData();
	}

}
