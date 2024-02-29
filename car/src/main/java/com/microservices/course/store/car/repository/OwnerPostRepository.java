package com.microservices.course.store.car.repository;

import com.microservices.course.store.car.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}
