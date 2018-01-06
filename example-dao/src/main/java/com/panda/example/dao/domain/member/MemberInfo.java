package com.panda.example.dao.domain.member;

import java.io.Serializable;

/**
 * 会员信息
 *
 */
public class MemberInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1201474724664705406L;

	/**
	 * 会员ID
	 */
	private Long memberId;

	/**
	 * 会员名称
	 */
	private String name;
	
	

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
