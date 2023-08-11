package com.project.concesionaria.domain.service;

import com.project.concesionaria.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con todas las marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche por su id
     * @param id Id de la marca de coche
     * @return Marca de coche por su id
     */
    Optional<BrandCarPojo> getBrandCar(Long id);


    /**
     * Guarda una marca de coche
     * @param brandCarPojo Marca de coche a guardar
     * @return Marca de coche guardada
     */
    BrandCarPojo save(BrandCarPojo brandCarPojo);

    /**
     * Actualiza una marca de coche
     * @param brandCarPojoUpdate Marca de coche a actualizar
     * @return Marca de coche actualizada
     */
    Optional <BrandCarPojo> update(BrandCarPojo brandCarPojoUpdate);


    /**
     * Elimina una marca coche por si Id
     * @param id
     */
    boolean delete(Long id);

}
