package com.example.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class KafkaProducer {

    private final KafkaTemplate<String,DemoDto> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, DemoDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message)
//    {
//       kafkaTemplate.send("ms-tpoic",message);
//
//       return "Message sent: "+message;
//    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message)
    {
        DemoDto demoDto=new DemoDto("Rahul",21);
        kafkaTemplate.send("ms-tpoic",demoDto);

        return "Message sent: "+demoDto.toString();
    }

}
