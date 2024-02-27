package com.microservices.course.main.service;

import com.microservices.course.main.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSale(CarPostDTO dto, String id);

    void removeCarForSale(String id);
}
