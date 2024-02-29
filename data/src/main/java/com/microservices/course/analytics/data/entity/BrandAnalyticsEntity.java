package com.microservices.course.analytics.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "car_brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private BigDecimal posts;


}
