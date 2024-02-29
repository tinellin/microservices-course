package com.microservices.course.store.car.service.impl;

import com.microservices.course.store.car.dto.OwnerPostDTO;
import com.microservices.course.store.car.entity.OwnerPostEntity;
import com.microservices.course.store.car.repository.OwnerPostRepository;
import com.microservices.course.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepo;

    @Override
    public void createOwnerPost(OwnerPostDTO dto) {
        ownerPostRepo.save(new OwnerPostEntity(dto));
    }
}
