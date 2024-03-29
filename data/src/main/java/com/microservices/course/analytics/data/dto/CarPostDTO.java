package com.microservices.course.analytics.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private LocalDateTime createdDate;

    private Long ownerId;

    private String ownerName;

    private String ownerType;

    private String contact;
}
