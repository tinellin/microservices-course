package com.microservices.course.analytics.data.repository;

import com.microservices.course.analytics.data.entity.BrandAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandAnalyticsRepository extends JpaRepository<BrandAnalyticsEntity, Long> {

    Optional<BrandAnalyticsEntity> findByBrand(String brand);
}
