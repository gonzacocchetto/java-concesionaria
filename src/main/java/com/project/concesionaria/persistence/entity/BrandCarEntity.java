package com.project.concesionaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @JoinColumn(name = "descripcion", insertable = false, updatable = false)
    private String description;

}
