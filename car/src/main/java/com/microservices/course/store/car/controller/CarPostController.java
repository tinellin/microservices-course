package com.microservices.course.store.car.controller;

import com.microservices.course.store.car.dto.CarPostDTO;
import com.microservices.course.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.FOUND)
    public List<CarPostDTO> getCarSales() {
        return carPostService.getCarForSales();
    }

    @PutMapping("/car/{id}")
    public void changeCarSale(@PathVariable Long id, @RequestBody CarPostDTO dto) {
        carPostService.changeCarForSale(id, dto);
    }

    @DeleteMapping("/car/{id}")
    public void changeCarSale(@PathVariable Long id) {
        carPostService.deleteCarForSale(id);
    }
}
