package com.microservices.course.store.car.controller;

import com.microservices.course.store.car.dto.OwnerPostDTO;
import com.microservices.course.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public void createOwner(@RequestBody OwnerPostDTO dto) {
        ownerPostService.createOwnerPost(dto);
    }
}
