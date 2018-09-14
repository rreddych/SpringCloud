package com.example.hystrixserverbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HystrixServerBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixServerBookstoreApplication.class, args);
	}
	
	@RequestMapping("recommended")
	public String ReadingList() {
		return "Morning Miracle, Getting things Done, Pomodoro Technique";
	}
}
