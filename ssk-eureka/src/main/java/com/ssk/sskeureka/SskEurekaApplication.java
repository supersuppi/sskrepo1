package com.ssk.sskeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SskEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SskEurekaApplication.class, args);
	}
}
