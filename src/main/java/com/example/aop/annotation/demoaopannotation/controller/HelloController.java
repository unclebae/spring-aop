package com.example.aop.annotation.demoaopannotation.controller;

import com.example.aop.annotation.demoaopannotation.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    GreetingService greetingServicen;

    @GetMapping("/hello/{userName}")
    public String greeting(@PathVariable("userName") String userName) {
        return greetingServicen.greeting(userName);
    }

}
