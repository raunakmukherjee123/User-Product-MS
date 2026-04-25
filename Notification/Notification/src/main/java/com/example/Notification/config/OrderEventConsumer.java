package com.example.Notification.config;

import com.example.Notification.ProductMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    @Value("${rabbitmq.queue.name")
    private String queueName;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleEvent(ProductMessageDto productMessageDto)
    {
        System.out.println("The product id received: "+productMessageDto.getId());
        System.out.println("The user id received: "+productMessageDto.getUserId());
        System.out.println("The product name received: "+productMessageDto.getName());
    }
}
