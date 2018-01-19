package com.panda.example.rmq.consumer.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.panda.example.rmq.consumer.listener.HelloListener;

@Configuration
public class RabbitConfig {

	@Bean
	public ConnectionFactory connectionFactory(RabbitProperties properties) {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(properties.getHost());
		connectionFactory.setPort(properties.getPort());
		connectionFactory.setUsername(properties.getUsername());
		connectionFactory.setPassword(properties.getPassword());
		connectionFactory.setVirtualHost(properties.getVirtualHost());
		connectionFactory.setPublisherConfirms(true); // 必须要设置
		return connectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		return template;
	}

	@Bean
	public Queue queue() {
		return new Queue("spring-boot-queue", true); // 队列持久

	}

	@Bean
	public SimpleMessageListenerContainer messageContainer(HelloListener listener,
			ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueues(queue());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setMessageListener(listener);
		return container;
	}
}
