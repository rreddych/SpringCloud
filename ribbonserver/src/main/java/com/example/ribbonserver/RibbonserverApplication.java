package com.example.ribbonserver;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RibbonserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonserverApplication.class, args);
	}
	
	@RequestMapping("/greetings")
	public String getGreetings() {
		System.out.println("Accessing /greetings");
		List<String> greetingList = Arrays.asList("Hi There", "Salutations", "How are you doing!");
		Random random = new Random();
		int nextNumber = random.nextInt(greetingList.size());
		String nextGreeting = greetingList.get(nextNumber);
		System.out.println(nextGreeting);
		return nextGreeting;
	}
	
	/*This root mapping method is needed as the Ribbon Client pings the server instance
	 * to check the availability of the instance and route the requests (balances the load) accordingly*/
	@RequestMapping("/")
	public String home() {
		System.out.println("Accessing /");
		return "Hi!";
	}
}
