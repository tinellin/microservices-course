package com.microservices.course.analytics.data.repository;

import com.microservices.course.analytics.data.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {

    Optional<CarModelAnalyticsEntity> findByModel(String model);
}
