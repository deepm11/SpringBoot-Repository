package com.example.SpringRabbitProducer_D38.controller;


import com.example.SpringRabbitProducer_D38.service.MessageProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/messages")
    public class MessageController {

        private final MessageProducerService service;

        public MessageController(MessageProducerService service) {
            this.service = service;
        }

        @PostMapping
        public String send(@RequestParam String message) {
            service.sendMessage(message);
            return "Message Sent Successfully";
        }
}

