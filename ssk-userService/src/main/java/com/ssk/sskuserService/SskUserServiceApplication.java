package com.ssk.sskuserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient //to be discovery-aware so this client can register with eureka server
@SpringBootApplication
public class SskUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SskUserServiceApplication.class, args);
	}
	
	@RestController
	class ServiceInstanceRestController {
		
		@Autowired
		private EventSender eventSender;
		
		@Autowired
		private MessageSender rabbitMsgSender;

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }
	    
		@RequestMapping("/hello")
	    public String hello() {
	        return "hello from user service";
	    }
		
		@RequestMapping("/kafka/sendEvent")
	    public String kafkaEventSend() {
			eventSender.send("USER-PRODUCT-PURCHASE", "Anil purchased mozy product");
	        return "event send sucessfully to product service";
	    }
		
		@RequestMapping("/rabbit/sendEvent")
	    public String rabbitEventSend() {
			rabbitMsgSender.sendMessage("1234");
	        return "event send sucessfully to product service";
	    }
	    
	    @RequestMapping("/userServiceClient")
	    public String greeting() {
	        return "Hello from UserService EurekaClient!";
	    }
	}
}
