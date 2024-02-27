package com.microservices.course.main.controller;

import com.microservices.course.main.dto.OwnerPostDTO;
import com.microservices.course.main.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public void create(@RequestBody OwnerPostDTO dto) {
        ownerPostService.createOwnerCar(dto);
    }
}
