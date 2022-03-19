package com.kafka.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroserviceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
//		return args -> {
//			for (int i = 0; i < 100; i++) {
//				// Same value in KafkaProducerConfig.newTopic() and KafkaConsumerConfig.consumerFactory()
//				kafkaTemplate.send("KafkaMicroserviceTest", new Message("Hello Kafka-" + i, LocalDateTime.now()));
//			}
//		};
//	}

}
