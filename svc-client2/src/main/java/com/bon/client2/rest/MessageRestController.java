package com.bon.client2.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/message")
public class MessageRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String retrieveMessage() {
        return "Super message";
    }

    @RequestMapping(value = "/client")
    @HystrixCommand(fallbackMethod = "retrieveClientMessageFallback")
    public String retrieveClientMessage() {
        return restTemplate.getForObject("http://client:8081/client/message/", String.class);
    }

    public String retrieveClientMessageFallback() {
        return "fallback";
    }
}
