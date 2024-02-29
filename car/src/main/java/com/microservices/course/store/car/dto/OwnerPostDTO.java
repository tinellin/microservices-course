package com.microservices.course.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservices.course.store.car.entity.OwnerPostEntity.OwnerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude
public class OwnerPostDTO {

    private String name;

    private OwnerType type;

    private String contactNumber;
}
