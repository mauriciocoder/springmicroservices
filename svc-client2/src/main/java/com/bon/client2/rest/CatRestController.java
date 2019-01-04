package com.bon.client2.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cat")
public class CatRestController {

    @RequestMapping(value = "/")
    @HystrixCommand
    public String retrieveCat() {
        return "Meow!";
    }
}
