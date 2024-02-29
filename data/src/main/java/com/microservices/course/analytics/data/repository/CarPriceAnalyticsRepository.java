package com.microservices.course.analytics.data.repository;

import com.microservices.course.analytics.data.entity.CarModelAnalyticsEntity;
import com.microservices.course.analytics.data.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {

}
