package com.microservices.course.analytics.data.message;

import com.microservices.course.analytics.data.dto.CarPostDTO;
import com.microservices.course.analytics.data.service.PostAnalyticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerMessage {

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(@Payload CarPostDTO dto) {
        log.info("Analytics Data - Received Car Post Information: {}", dto);
        postAnalyticsService.saveDataAnalytics(dto);
    }

}
