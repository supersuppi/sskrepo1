package com.ssk.mozy.sskmozyapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssk.mozy.model.Partner;
import com.ssk.mozy.security.JwtFilter;

@SpringBootApplication(scanBasePackages={"com.ssk.mozy"}) // scan is required
@EnableJpaRepositories("com.ssk.mozy.repository") //required
@EntityScan("com.ssk.mozy.model") // required
public class SskMozyApiApplication {
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

	public static void main(String[] args) {
		SpringApplication.run(SskMozyApiApplication.class, args);
	}
	
}
