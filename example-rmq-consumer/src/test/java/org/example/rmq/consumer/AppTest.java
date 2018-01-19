package org.example.rmq.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class AppTest {
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	Queue queue;

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {
		rabbitTemplate.convertAndSend("spring-boot-queue", "hello 况小锋");
	}
}
