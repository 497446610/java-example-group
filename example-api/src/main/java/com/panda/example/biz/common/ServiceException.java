package com.panda.example.biz.common;

/**
 * 服务异常
 *
 */
public class ServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
	
}
