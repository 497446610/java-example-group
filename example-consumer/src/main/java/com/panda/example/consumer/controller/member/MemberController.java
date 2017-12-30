package com.panda.example.consumer.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.example.biz.api.member.IMemberService;

@RestController
public class MemberController {

	@Autowired
	IMemberService memberSerivce;

	@RequestMapping("/hello")
	public String sayHello(String name) {
		return memberSerivce.sayHello(name);
	}

}
