package com.microservices.course.main.client;

import com.microservices.course.main.dto.CarPostDTO;
import com.microservices.course.main.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://car-api:8086/user";
    private final String POSTS_STORE_SERVICE_URI = "http://car-api:8086/sales";

    @Autowired
    private RestTemplate restTemplate;

    public List<CarPostDTO> carForSaleClient() {
        ResponseEntity<CarPostDTO[]> response = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public void ownerPostsClient(OwnerPostDTO newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO dto, String id) {
        restTemplate.put(POSTS_STORE_SERVICE_URI + "/car" + id, dto, CarPostDTO.class);
    }

    public void deleteCarForSale(String id) {
        restTemplate.delete(POSTS_STORE_SERVICE_URI + "/car" + id);
    }

}
