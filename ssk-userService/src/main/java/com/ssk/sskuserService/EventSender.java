package com.ssk.sskuserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class EventSender {
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
 
    public void send(String topic, Object payload) {
    	try {
    		kafkaTemplate.send(topic, payload);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}
