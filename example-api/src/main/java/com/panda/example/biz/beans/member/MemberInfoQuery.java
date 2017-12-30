package com.panda.example.biz.beans.member;

import java.io.Serializable;

import com.panda.example.biz.common.PageParam;

/**
 * 会员信息查询条件
 *
 */
public class MemberInfoQuery extends PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4487419333750850126L;

	/**
	 * 会员名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
