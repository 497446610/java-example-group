package com.panda.example.biz.api.mq;

/**
 * mq消息服务
 * 
 * @author Administrator
 *
 */
public interface IMQService {
	
	
	public void sendMQMsg(String quenue,Object msg);

}
