package com.udemy.kafka.applicationdemoconsumer.consumer;

import com.udemy.kafka.applicationdemoconsumer.dto.CarDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);

    @Value("${topic.name}")
    private String topic;

    @Value("${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "getConcurrentKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, CarDTO> record){
        logger.info("Received message " +record.partition());
        logger.info("Received message " +record.value());
    }
}
