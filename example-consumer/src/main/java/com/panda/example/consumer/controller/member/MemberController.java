package com.panda.example.consumer.controller.member;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.panda.example.biz.api.member.IMemberService;
import com.panda.example.consumer.beans.member.Demo;
import com.panda.example.consumer.controller.AjaxResult;
import com.reger.dubbo.annotation.Inject;

@RestController
public class MemberController {

	@Inject(value=@Reference(group="example",version="*"))
	IMemberService memberSerivce;

	@RequestMapping("/hello")
	public String sayHello(String name) {
		return memberSerivce.sayHello(name);
	}

	@RequestMapping("/cache")
	public String cache() {
		return memberSerivce.cacheData();
	}

	/**
	 * 数据验证demo
	 * 
	 * @param demo
	 * @param result
	 * @return
	 */
	@RequestMapping("valid")
	public AjaxResult valid(@Valid Demo demo, BindingResult result) {
		if (result.hasErrors()) {
			return AjaxResult.validfail(result.getAllErrors());
		}
		return AjaxResult.success("数据验证成功!");
	}

}
