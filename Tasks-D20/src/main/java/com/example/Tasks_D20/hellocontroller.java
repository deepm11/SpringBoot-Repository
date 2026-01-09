package com.example.Tasks_D20;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

 private  final MessageService messageService;


    public hellocontroller(MessageService messageService) {
        this.messageService=messageService;
    }

    @GetMapping("/hello")
    public String hello(){
        return messageService.getMessage();
    }
}

