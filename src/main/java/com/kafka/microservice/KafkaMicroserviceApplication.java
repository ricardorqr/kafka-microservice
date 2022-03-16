package com.kafka.microservice;

import com.kafka.microservice.model.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				// Same value in KafkaProducerConfig.newTopic() and KafkaConsumerConfig.consumerFactory()
				kafkaTemplate.send("KafkaMicroserviceTest", new Message("Hello Kafka-" + i, LocalDateTime.now()));
			}
		};
	}

}
