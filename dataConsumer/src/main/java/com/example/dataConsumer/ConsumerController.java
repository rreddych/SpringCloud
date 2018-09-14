package com.example.dataConsumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	DiscoveryClient discoveryClient;
		
	@RequestMapping("employeesfromDataExposer")
	@ResponseBody
	public String getEmployeesFromDataExposer(){
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("a-data-exposer");
		URI uri = serviceInstances.get(0).getUri();
		String url = uri.toString() + "/employees";
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		String body = responseEntity.getBody();
		System.out.println(body);
		return body;
	}
}
