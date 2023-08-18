package com.project.concesionaria.domain.useCase;

import com.project.concesionaria.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    List<CarDto> getAll();

    List<CarDto> getByIdBrand(Long idBrand);

    List<CarDto> getCarsByPrice(Double price);

    Optional<CarDto> getCar(Long id);


    CarDto save(CarDto newCar);

    boolean delete(Long id);

}
