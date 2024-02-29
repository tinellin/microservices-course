package com.microservices.course.store.car.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
public class CarPostEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model", nullable = false, length = 100)
    private String model;

    @Column(name = "car_brand", nullable = false, length = 60)
    private String brand;

    @Column(name = "car_price", nullable = false)
    private BigDecimal price;

    @Column(name = "car_description", nullable = false)
    private String description;

    @Column(name = "car_engine", nullable = false, length = 30)
    private String engineVersion;
    @Column(name = "car_city", nullable = false, length = 60)
    private String city;

    @Column(name = "car_created")
    private LocalDateTime createdDate;

    @Column(name = "car_post_contact", nullable = false, length = 100)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;

    public CarPostEntity(String model, String brand, BigDecimal price, String description, String engineVersion, String city, String contact, OwnerPostEntity ownerPost) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = LocalDateTime.now();
        this.contact = contact;
        this.ownerPost = ownerPost;
    }
}
