package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.dto.BrandCarDto;
import com.project.concesionaria.domain.repository.IBrandCarRepository;
import com.project.concesionaria.domain.useCase.IBrandCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarUseCase {

    private final IBrandCarRepository iBrandCarRepository;

    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Long id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarDto save(BrandCarDto brandCarDto) {
        return iBrandCarRepository.save(brandCarDto);
    }

    @Override
    public Optional <BrandCarDto> update(BrandCarDto brandCarDtoUpdate) {
        if (iBrandCarRepository.getBrandCar(brandCarDtoUpdate.getId()).isEmpty()) {
            return Optional.empty();
        } else {

            return Optional.of(iBrandCarRepository.save(brandCarDtoUpdate));
        }

    }

    @Override
    public boolean delete(Long id) {
       if(iBrandCarRepository.getBrandCar(id).isEmpty()) {
           return false;
       } else {
           iBrandCarRepository.delete(id);
           return true;
       }
    }
}
