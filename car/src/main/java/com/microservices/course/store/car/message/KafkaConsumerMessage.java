package com.microservices.course.store.car.message;

import com.microservices.course.store.car.dto.CarPostDTO;
import com.microservices.course.store.car.service.CarPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerMessage {

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO dto) {
        log.info("Received car post information: {}", dto);
        carPostService.newPostDetails(dto);
    }
}
