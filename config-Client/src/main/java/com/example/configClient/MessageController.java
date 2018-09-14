package com.example.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {
	
	@Value("${message}")
	private String message;
	
	@RequestMapping("/message")
	@ResponseBody
	public String getMessage() {
		return this.message;
		//return "Hello World!";
	}

}
