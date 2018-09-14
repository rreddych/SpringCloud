package com.example.hystrixclientbookreading;

import static org.hamcrest.CoreMatchers.nullValue;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*Hystrix looks for any method annotated with the @HystrixCommand annotation, 
 * and wraps that method in a proxy connected to a circuit breaker so that Hystrix can monitor it.
 *  This currently only works in a class marked with @Component or @Service. 
 *  So you cannot directly annotate over controller methods in a @RestController class.*/
@Service
public class BookReadingService {
	
	private RestTemplate restTemplate;
	
	public BookReadingService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		// TODO Auto-generated constructor stub
	}
	
	@HystrixCommand(fallbackMethod = "getDefaultReadingList")
	public String getReadingList() {
		String response = null;
		try {
			URI uri = URI.create("http://localhost:8086/recommended");
			response = restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			System.out.println("In getReadingList "+e.getMessage());
			System.out.println("In getReadingList " + e.getCause());
			System.out.println("In getReadingList " + e.getStackTrace());
			// TODO: handle exception
		}
		return response;
	}
	
	private String getDefaultReadingList() {
		return "Morning Miracle";
	}

}
