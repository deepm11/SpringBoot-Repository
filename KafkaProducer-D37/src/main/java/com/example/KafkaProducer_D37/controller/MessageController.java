package com.example.KafkaProducer_D37.controller;

import com.example.KafkaProducer_D37.Service.MessageProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducerService producerService;

    public MessageController(MessageProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping

    public ResponseEntity<String> send(@RequestBody String message)
    {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }


}
