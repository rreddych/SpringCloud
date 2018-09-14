package com.example.eurekadiscovery;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServiceInstancesRestController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{appName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String appName){
		List<ServiceInstance> instanceList = null;
		instanceList = discoveryClient.getInstances(appName);
		for (ServiceInstance serviceInstance : instanceList) {
			URI uri = serviceInstance.getUri();
		}
		return instanceList;
	}

}
