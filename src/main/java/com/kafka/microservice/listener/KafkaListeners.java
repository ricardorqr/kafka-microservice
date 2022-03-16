package com.kafka.microservice.listener;

import com.kafka.microservice.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    // Same value in KafkaProducerConfig.newTopic() and KafkaConsumerConfig.consumerFactory()
    @KafkaListener(topics = "KafkaMicroserviceTest", groupId = "KafkaGroupId", containerFactory = "messageListenerFactory")
    public void listener(Message message) {
        System.out.println("Listener Received: " + message);
    }

}
