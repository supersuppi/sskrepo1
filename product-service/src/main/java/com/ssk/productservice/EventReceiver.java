package com.ssk.productservice;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class EventReceiver {

	private CountDownLatch latch = new CountDownLatch(1);
	 
	@KafkaListener(topics = "USER-PRODUCT-PURCHASE")
	public void receive(Object payload) {
	   System.out.println("SSK-Event Message Received: "+payload.toString());
	   latch.countDown();
	}
}
