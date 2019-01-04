package com.bon.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RequestMapping("/client")
public class Application {

	@Value("${message}")
	private String message;

	@RequestMapping("/message")
	public String getConfiguredMessage() {
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
