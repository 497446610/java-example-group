package com.panda.example.consumer.controller.member;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.panda.example.biz.api.BizModuleInfo;
import com.panda.example.biz.api.member.IMemberService;
import com.panda.example.biz.beans.member.MemberInfoQuery;
import com.panda.example.biz.common.PageResult;
import com.panda.example.biz.common.ServiceException;
import com.panda.example.consumer.beans.member.Demo;
import com.panda.example.consumer.controller.AjaxResult;

@RestController
public class MemberController {
	private final static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Reference(group = BizModuleInfo.group, version = BizModuleInfo.version,retries=0)
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
	public AjaxResult valid(@Valid Demo demo, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
			return AjaxResult.validfailed(bindResult.getAllErrors());
		}
		return AjaxResult.success("数据验证成功!");
	}

	@RequestMapping("/listMember")
	public AjaxResult listMember(MemberInfoQuery query, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
			return AjaxResult.validfailed(bindResult.getAllErrors());
		}
		try {
			PageResult result = memberSerivce.queryMember(query);
			return AjaxResult.success(result);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			return AjaxResult.failed(e.getMessage());
		}

	}

}
