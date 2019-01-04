package com.bon.svcclient3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/message")
	public String message() {
		return "Message from " + port;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
