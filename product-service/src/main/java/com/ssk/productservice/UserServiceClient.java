package com.ssk.productservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
public interface UserServiceClient {

	@RequestMapping("/userServiceClient")
    String getUserService();
}
