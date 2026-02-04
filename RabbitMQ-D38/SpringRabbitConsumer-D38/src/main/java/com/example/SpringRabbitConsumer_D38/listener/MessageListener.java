package com.example.SpringRabbitConsumer_D38.listener;

import com.example.SpringRabbitConsumer_D38.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received Message: " + message);
    }
}
