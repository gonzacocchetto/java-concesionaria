package com.project.concesionaria.persistence.repository.impl;

import com.project.concesionaria.domain.dto.CarDto;
import com.project.concesionaria.domain.repository.ICarRepository;
import com.project.concesionaria.persistence.entity.CarEntity;
import com.project.concesionaria.persistence.mapper.ICarMapper;
import com.project.concesionaria.persistence.repository.ICarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;

    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarDto(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrand(Long idBrand) {
        return iCarMapper.toCarDto(iCarCrudRepository.findAllByBrandCarId(idBrand));
    }

    @Override
    public List<CarDto> getCarsByPrice(Double price) {
        return iCarMapper.toCarDto(iCarCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public Optional<CarDto> getCar(Long id) {
        return iCarCrudRepository.findById(id)
                .map(iCarMapper::mapToCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {
        CarEntity carEntity = iCarMapper.mapToCarEntity(newCar);
        return iCarMapper.mapToCarDto(iCarCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Long id) {
        iCarCrudRepository.deleteById(id);

    }
}
