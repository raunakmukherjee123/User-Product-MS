package com.example.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// for creating new topic

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic mynewTopic()
    {
        return new NewTopic("ms-topic-2",3,(short) 1);
    }
}
