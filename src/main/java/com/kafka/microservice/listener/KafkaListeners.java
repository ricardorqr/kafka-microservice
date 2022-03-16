package com.kafka.microservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    // Same value in KafkaTopicConfig.newTopic()
    @KafkaListener(topics = "KafkaMicroserviceTest", groupId = "testGroupId")
    public void listener(String data) {
        System.out.println("Listener Received: " + data + " 👌");
    }

}
