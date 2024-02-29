package com.microservices.course.main.service;

import com.microservices.course.main.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO dto);
}
