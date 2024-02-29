package com.microservices.course.store.car.service;

import com.microservices.course.store.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO dto);

    List<CarPostDTO> getCarForSales();

    void changeCarForSale(Long id, CarPostDTO dto);

    void deleteCarForSale(Long id);

}
