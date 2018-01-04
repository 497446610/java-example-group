package com.panda.example.biz.api.impl.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.panda.example.biz.api.mq.IMQService;

@Component("MQService")
public class MQServiceImpl implements IMQService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void sendMQMsg(String quenue, Object msg) {
		rabbitTemplate.convertAndSend(quenue, msg);
	}
	
	

	
}
