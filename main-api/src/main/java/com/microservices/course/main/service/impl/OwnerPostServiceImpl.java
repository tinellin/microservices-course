package com.microservices.course.main.service.impl;

import com.microservices.course.main.client.CarPostStoreClient;
import com.microservices.course.main.dto.OwnerPostDTO;
import com.microservices.course.main.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO dto) {
        carPostStoreClient.ownerPostsClient(dto);
    }
}
