package com.microservices.course.store.car.service.impl;

import com.microservices.course.store.car.dto.CarPostDTO;
import com.microservices.course.store.car.entity.CarPostEntity;
import com.microservices.course.store.car.entity.OwnerPostEntity;
import com.microservices.course.store.car.repository.CarPostRepository;
import com.microservices.course.store.car.repository.OwnerPostRepository;
import com.microservices.course.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepo;

    @Autowired
    private OwnerPostRepository ownerPostRepo;

    @Override
    public void newPostDetails(CarPostDTO dto) {
        CarPostEntity carPostEntity = mapCarDtoToEntity(dto);
        carPostRepo.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> getCarForSales() {
        return carPostRepo.findAll().stream().map(this::mapCarEntityToDto).toList();
    }
    @Override
    public void changeCarForSale(Long id, CarPostDTO dto) {
        carPostRepo.findById(id).ifPresentOrElse(item -> {
            item.setBrand(dto.getBrand());
            item.setModel(dto.getModel());
            item.setEngineVersion(dto.getEngineVersion());
            item.setDescription(dto.getDescription());
            item.setPrice(dto.getPrice());
            item.setContact(dto.getContact());

            carPostRepo.save(item);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void deleteCarForSale(Long id) {
        carPostRepo.deleteById(id);
    }

    private CarPostDTO mapCarEntityToDto(CarPostEntity e) {
        return CarPostDTO.builder()
                .model(e.getModel())
                .brand(e.getBrand())
                .price(e.getPrice())
                .description(e.getDescription())
                .engineVersion(e.getEngineVersion())
                .city(e.getCity())
                .createdDate(e.getCreatedDate())
                .ownerName(e.getOwnerPost().getName())
                .build();
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO dto) {

        OwnerPostEntity owner = ownerPostRepo.findById(dto.getOwnerId()).orElseThrow(RuntimeException::new);

        return new CarPostEntity(dto.getModel(), dto.getBrand(), dto.getPrice(),
                dto.getDescription(), dto.getEngineVersion(), dto.getCity(), owner.getContactNumber(), owner);
    }
}
