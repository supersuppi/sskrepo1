package com.ssk.productservice;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	@RabbitListener(queues = {RabbitMQConsumerConfig.ROUTING_KEY})
	@RabbitHandler
	public void onMessage(String message) {
		System.out.println("Message Received:"+message);
		System.out.println(new Date());

	}
}
