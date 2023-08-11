package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.pojo.BrandCarPojo;
import com.project.concesionaria.domain.repository.IBrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService {

    private final IBrandCarRepository iBrandCarRepository;

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Long id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarPojo save(BrandCarPojo brandCarPojo) {
        return iBrandCarRepository.save(brandCarPojo);
    }

    @Override
    public Optional <BrandCarPojo> update(BrandCarPojo brandCarPojoUpdate) {
        if (iBrandCarRepository.getBrandCar(brandCarPojoUpdate.getId()).isEmpty()) {
            return Optional.empty();
        } else {

            return Optional.of(iBrandCarRepository.save(brandCarPojoUpdate));
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
