package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

//    @KafkaListener(topics = "ms-tpoic",groupId = "ms-group")
//    public void listen(String message)
//    {
//        System.out.println("Message received: "+message);
//    }

    @KafkaListener(topics = "ms-tpoic",groupId = "ms-group")
    public void listen(DemoDto demoDto)
    {
        System.out.println("Message received from: "+demoDto.getName());
    }

//    @KafkaListener(topics = "ms-tpoic",groupId = "ms-group-1")
//    public void listen1(String message)
//    {
//        System.out.println("Message received: "+message);
//    }
}
