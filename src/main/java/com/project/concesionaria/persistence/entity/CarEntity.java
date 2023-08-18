package com.project.concesionaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "coche")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codico_coche")
    private Long codecar;

    @Column(name = "marca_coche_id")
    private Integer brandCarId;

    @Column(name = "referencia")
    private String reference;

    @Column(name = "precio")
    private Double price;

    @Column(name = "modelo_anio")
    private Double modelYear;

    private String color;

    @Column(name = "numero_caballos_fuerza")
    private Double horspower;

    @Column(name = "cantidad_puertas")
    private Integer numberDoors;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "transmision")
    private String transmission;

    @Column(name = "tipo_combustible")
    private String fuelType;

    @Column(name = "numero_asientos")
    private Integer numberSeats;

    @Column(name = "traccion")
    private Integer traction;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;

    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;
}
