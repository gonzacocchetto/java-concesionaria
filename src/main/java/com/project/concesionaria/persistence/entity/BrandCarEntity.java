package com.project.concesionaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad de marca coche
 */
@Getter @Setter
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}
