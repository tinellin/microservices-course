package com.microservices.course.store.car.repository;

import com.microservices.course.store.car.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
}
