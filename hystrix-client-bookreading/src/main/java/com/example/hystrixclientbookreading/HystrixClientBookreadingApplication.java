package com.example.hystrixclientbookreading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class HystrixClientBookreadingApplication {
	
	@Autowired
	private BookReadingService bookReadingService;

	public static void main(String[] args) {
		SpringApplication.run(HystrixClientBookreadingApplication.class, args);
	}
	
	@RequestMapping("to-read")
	public String ReadingList() {
		return this.bookReadingService.getReadingList();
		
	}
	
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
