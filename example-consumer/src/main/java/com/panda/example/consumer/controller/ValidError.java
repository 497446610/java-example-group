package com.panda.example.consumer.controller;

/**
 * 验证错误信息
 *
 */
public class ValidError {
	
	/**
	 * 错误字段
	 */
	private String field;
	
	/**
	 * 错误信息
	 */
	private String message;

	public ValidError(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
