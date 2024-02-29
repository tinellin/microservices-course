package com.microservices.course.analytics.data.service;

import com.microservices.course.analytics.data.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDTO dto);
}
