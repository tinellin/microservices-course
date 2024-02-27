package com.microservices.course.main.service.impl;

import com.microservices.course.main.client.CarPostStoreClient;
import com.microservices.course.main.dto.CarPostDTO;
import com.microservices.course.main.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSales() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO dto, String id) {
        carPostStoreClient.changeCarForSaleClient(dto, id);
    }

    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSale(id);
    }
}
