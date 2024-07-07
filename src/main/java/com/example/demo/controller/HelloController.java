package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//we need to make this a component so that the beans form this class can be accessed
// the controller annotation contains component

// the rest controller unlike Controller annotation always returns a response body
@RestController
public class HelloController {

    //getting the values from the config files
    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String sayHello() {
        System.out.println(message);
        return message;
    }
}
