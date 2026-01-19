package com.example.SpringSecurity_D28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

@GetMapping("/public")
    public String publicApi(){
    return "This is the public api";
}


@GetMapping("/user")
    public String userApi(){
    return "Hello user api";
}

@GetMapping("/admin")
    public String adminApi(){
    return "hello ADMIN ";
}

}
