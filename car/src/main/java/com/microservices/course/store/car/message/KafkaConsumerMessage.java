package com.microservices.course.store.car.message;

import com.microservices.course.store.car.dto.CarPostDTO;
import com.microservices.course.store.car.service.CarPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerMessage {
    @Autowired
    private CarPostService carPostService;
    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(@Payload CarPostDTO dto) {
        log.info("Car Store - Received Car Post Information: {}", dto);
        System.out.println("\n\n\n" + dto + "\n\n\n");
        carPostService.newPostDetails(dto);
    }
}
