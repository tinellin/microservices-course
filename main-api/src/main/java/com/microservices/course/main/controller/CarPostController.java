package com.microservices.course.main.controller;

import com.microservices.course.main.dto.CarPostDTO;
import com.microservices.course.main.message.KafkaProducerMessage;
import com.microservices.course.main.service.CarPostStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@Slf4j
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.FOUND)
    public List<CarPostDTO> getAll() {
        return carPostStoreService.getCarForSales();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CarPostDTO dto) {
        log.info("Using Kafka events - Producer Car Post Information: {}", dto);
        kafkaProducerMessage.sendMessage(dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CarPostDTO dto, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
    }
}
