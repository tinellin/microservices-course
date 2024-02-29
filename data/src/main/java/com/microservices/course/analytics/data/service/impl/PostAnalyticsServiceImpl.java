package com.microservices.course.analytics.data.service.impl;

import com.microservices.course.analytics.data.dto.CarPostDTO;
import com.microservices.course.analytics.data.entity.BrandAnalyticsEntity;
import com.microservices.course.analytics.data.entity.CarModelAnalyticsEntity;
import com.microservices.course.analytics.data.entity.CarModelPriceEntity;
import com.microservices.course.analytics.data.repository.BrandAnalyticsRepository;
import com.microservices.course.analytics.data.repository.CarModelAnalyticsRepository;
import com.microservices.course.analytics.data.repository.CarPriceAnalyticsRepository;
import com.microservices.course.analytics.data.service.PostAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepo;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepo;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepo;

    @Override
    public void saveDataAnalytics(CarPostDTO dto) {
        saveBrandAnalytics(dto.getBrand());
        saveCarModelAnalytics(dto.getModel());
        saveCarModelPriceAnalytics(dto.getModel(), dto.getPrice());
    }

    private void saveBrandAnalytics(String brand) {
        brandAnalyticsRepo.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts().add(new BigDecimal(1)));
            brandAnalyticsRepo.save(item);
        }, () -> {
            BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(new BigDecimal(1));
            brandAnalyticsRepo.save(brandAnalyticsEntity);
        });
    }

    private void saveCarModelAnalytics(String carModel) {
        carModelAnalyticsRepo.findByModel(carModel).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts().add(new BigDecimal(1)));
            carModelAnalyticsRepo.save(item);
        }, () -> {
            CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();
            carModelAnalyticsEntity.setModel(carModel);
            carModelAnalyticsEntity.setPosts(new BigDecimal(1));
            carModelAnalyticsRepo.save(carModelAnalyticsEntity);
        });
    }

    private void saveCarModelPriceAnalytics(String carModel, BigDecimal price) {
        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepo.save(carModelPriceEntity);

    }
}
