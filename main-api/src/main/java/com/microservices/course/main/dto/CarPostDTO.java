package com.microservices.course.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude
public class CarPostDTO {
    private String model;

    private String brand;

    private BigDecimal price;

    private String description;

    private String engineVersion;

    private String city;

    private Long createdDate;

    private Long ownerId;

    private String ownerName;

    private String ownerType;

    private String contact;
}
