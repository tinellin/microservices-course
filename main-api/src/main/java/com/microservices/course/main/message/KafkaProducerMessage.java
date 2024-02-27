package com.microservices.course.main.message;

import com.microservices.course.main.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDTO dto) {
        kafkaTemplate.send(KAFKA_TOPIC, dto);
    }
}
