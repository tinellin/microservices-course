package com.microservices.course.store.car.controller;

import com.microservices.course.store.car.dto.OwnerPostDTO;
import com.microservices.course.store.car.service.OwnerPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public void createOwner(@RequestBody OwnerPostDTO dto) {
        log.info("Using Rest API - Received new user: {}", dto);
        ownerPostService.createOwnerPost(dto);
    }
}
