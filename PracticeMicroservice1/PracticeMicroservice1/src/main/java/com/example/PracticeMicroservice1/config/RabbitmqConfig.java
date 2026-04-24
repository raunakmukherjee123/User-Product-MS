package com.example.PracticeMicroservice1.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public Queue queue()
    {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Binding binding()
    {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }


}
