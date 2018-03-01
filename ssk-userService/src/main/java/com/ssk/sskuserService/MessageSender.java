package com.ssk.sskuserService;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message) {
		System.out.println("Sending msg....");
		rabbitTemplate.convertAndSend(RobbitMqSenderConfig.EXCHANGE_NAME,RobbitMqSenderConfig.ROUTING_KEY, message);
	
	    System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());
	    
	}
}
