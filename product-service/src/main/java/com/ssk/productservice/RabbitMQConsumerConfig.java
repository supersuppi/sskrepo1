package com.ssk.productservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConsumerConfig {
	
	public static final String ROUTING_KEY = "queue.customer.created";

	
	 @Bean
	 public MessageConverter messageConverter() {
	        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
	        //jsonMessageConverter.setClassMapper(classMapper());
	        return jsonMessageConverter;
	    }

	    @Bean
	    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
	        RabbitTemplate template = new RabbitTemplate(connectionFactory);
	        template.setMessageConverter(messageConverter());
	        return template;
	    }
	    
//	    @Bean
//	    public DefaultClassMapper classMapper() {
//	        DefaultClassMapper classMapper = new DefaultClassMapper();
//	        Map<String, Class<?>> idClassMapping = new HashMap<>();
//	        idClassMapping.put("com.springbootdev.examples.producer.model.Car", Car.class);
//	        classMapper.setIdClassMapping(idClassMapping);
//	        return classMapper;
//	    }
}
