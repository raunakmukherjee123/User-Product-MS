package com.example.Notification.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    @Value("${rabbitmq.queue.name")
    private String queueName;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleEvent(String message)
    {
        System.out.println("The message received: "+message);
    }
}
