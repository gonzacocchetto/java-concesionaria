package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

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
     * Actualiza una marca de coche
     * @param brandCarDtoUpdate Marca de coche a actualizar
     * @return Marca de coche actualizada
     */
    Optional <BrandCarDto> update(BrandCarDto brandCarDtoUpdate);


    /**
     * Elimina una marca coche por si Id
     * @param id
     */
    boolean delete(Long id);

}
