package com.project.concesionaria.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto que modela un coche
 */
@Getter @Setter
public class CarDto {

    private Integer codecar;
    private Integer brandCarId;
    private String reference;
    private Double price;
    private Double modelYear;
    private String color;
    private Double horspower;
    private Integer numberDoors;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeats;
    private Integer traction;
    private String steering;
    private String category;
    private String imagePath;


}
