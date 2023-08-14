package com.project.concesionaria.persistence.repository;

import com.project.concesionaria.domain.dto.BrandCarDto;
import com.project.concesionaria.domain.repository.IBrandCarRepository;
import com.project.concesionaria.persistence.entity.BrandCarEntity;
import com.project.concesionaria.persistence.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */
    //Se coloca final para que me permita crear el constructor lleno y se pueda usar @RequiredArgsConstructor
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcaCocheDto(iBrandCarCrudRepository.findAll());
    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Long id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::mapToMarcaCocheDto);
    }

    @Override //Recibo un nuevo dto(newBrandCar)
    public BrandCarDto save(BrandCarDto newBrandCar) {
        //Aca lo transformo en una entidad con el mapper y lo guardo en brandCarEntity
       BrandCarEntity brandCarEntity = iBrandCarMapper.mapToMarcaCocheEntity(newBrandCar);
       //Aca lo guardo (iBrandCarCrudRepository.save(brandCarEntity) y lo convierto en pojo (mapToMarcaCochePojo)
       return iBrandCarMapper.mapToMarcaCocheDto(iBrandCarCrudRepository.save(brandCarEntity));
       //Finalmente retorno el dto
    }


    @Override
    public void delete(Long id) {
        iBrandCarCrudRepository.deleteById(id);

    }
}
