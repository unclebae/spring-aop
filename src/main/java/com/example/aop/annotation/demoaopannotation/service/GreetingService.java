package com.example.aop.annotation.demoaopannotation.service;

import com.example.aop.annotation.demoaopannotation.aop.TimeLog;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GreetingService {

    @TimeLog
    public String greeting(String userName) {
        processSomething();
        return "Hello " + userName + " !!!";
    }

    private void processSomething() {
        try {
            Thread.sleep((new Random()).nextInt(1000));
        } catch (InterruptedException e) {
//            ...
        }
    }

}
