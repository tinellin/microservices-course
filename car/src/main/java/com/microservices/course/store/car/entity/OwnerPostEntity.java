package com.microservices.course.store.car.entity;

import com.microservices.course.store.car.dto.OwnerPostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "owner_type")
    @Enumerated(EnumType.STRING)
    private OwnerType type;

    public enum OwnerType {
        PARTICULAR,
        PROFESSIONAL
    }

    @Column(name = "owner_contact", nullable = false, length = 60)
    private String contactNumber;


    public OwnerPostEntity(OwnerPostDTO dto) {
        this.name = dto.getName();
        this.type = dto.getType();
        this.contactNumber = dto.getContactNumber();
    }
}
