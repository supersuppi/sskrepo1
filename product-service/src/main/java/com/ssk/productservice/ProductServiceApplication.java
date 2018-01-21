package com.ssk.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class ProductServiceApplication {
	
	@Autowired
	private UserServiceClient userServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@RequestMapping("/hello")
    public String hello() {
        return "hello from product service";
    }
	
	
	@RequestMapping("/check-userService")
    public String userServiceHeartBeat() {
        return userServiceClient.getUserService();
    }
	
}
