package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.dto.CarDto;
import com.project.concesionaria.domain.repository.ICarRepository;
import com.project.concesionaria.domain.useCase.ICarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;

    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrand(Long idBrand) {
        return iCarRepository.getByIdBrand(idBrand);
    }

    @Override
    public List<CarDto> getCarsByPrice(Double price) {
        return iCarRepository.getCarsByPrice(price);
    }

    @Override
    public Optional<CarDto> getCar(Long id) {
        return iCarRepository.getCar(id);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarRepository.save(newCar);
    }

    @Override
    public boolean delete(Long id) {
        if(iCarRepository.getCar(id).isEmpty()){
            return false;
        }
        iCarRepository.delete(id);
        return true;
    }
}
