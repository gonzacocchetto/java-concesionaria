package com.project.concesionaria.persistence.repository;

import com.project.concesionaria.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByBrandCarId(Long idBrand);

    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);


}
