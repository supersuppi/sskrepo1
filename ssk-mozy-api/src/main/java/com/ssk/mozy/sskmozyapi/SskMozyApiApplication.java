package com.ssk.mozy.sskmozyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.ssk.mozy"}) // scan is required
@EnableJpaRepositories("com.ssk.mozy.repository") //required
@EntityScan("com.ssk.mozy.model") // required
public class SskMozyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SskMozyApiApplication.class, args);
	}
}
