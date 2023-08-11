package com.project.concesionaria.domain.repository;

import com.project.concesionaria.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con todas las marcas de coches
     */
    List<BrandCarDto> getAll();

    /**
     * Devuelve una marca de coche por su id
     * @param id Id de la marca de coche
     * @return Marca de coche por su id
     */
    Optional<BrandCarDto> getBrandCar(Long id);


    /**
     * Guarda una marca de coche
     * @param brandCarDto Marca de coche a guardar
     * @return Marca de coche guardada
     */
    BrandCarDto save(BrandCarDto brandCarDto);


    /**
     * Elimina una marca coche por si Id
     * @param id
     */
    void delete(Long id);
}
