package com.project.concesionaria.domain.repository;

import com.project.concesionaria.domain.dto.BrandCarDto;
import com.project.concesionaria.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {


    List<CarDto> getAll();

    List<CarDto> getByIdBrand(Long idBrand);

    List<CarDto> getCarsByPrice(Double price);
    Optional<CarDto> getCar(Long id);


    CarDto save(CarDto newCar);

    void delete(Long id);
}
