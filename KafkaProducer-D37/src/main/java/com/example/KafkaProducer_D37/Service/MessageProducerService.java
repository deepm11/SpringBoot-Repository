package com.example.KafkaProducer_D37.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        kafkaTemplate.send("topic1", message);
    }

}
