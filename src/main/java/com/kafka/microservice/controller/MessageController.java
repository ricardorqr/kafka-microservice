package com.kafka.microservice.controller;

import com.kafka.microservice.model.Message;
import com.kafka.microservice.model.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping
    public void publisher(@RequestBody MessageRequest messageRequest) {
        Message message = new Message(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate.send("KafkaMicroserviceTest", message);
    }

}
