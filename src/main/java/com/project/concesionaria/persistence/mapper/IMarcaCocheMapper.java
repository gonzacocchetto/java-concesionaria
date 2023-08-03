package com.project.concesionaria.persistence.mapper;

import com.project.concesionaria.domain.pojo.MarcaCochePojo;
import com.project.concesionaria.persistence.entity.MarcaCocheEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * Convierte un objeto de marca coche a un pojo
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo mapToMarcaCochePojo(MarcaCocheEntity marcaEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaPojo Entidad a convertir
     * @return Entidad convertida
     */
    @InheritInverseConfiguration
    MarcaCocheEntity mapToMarcaCocheEntity(MarcaCochePojo marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcaCocheEntityList Entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCochePojo> toMarcaCochePojoList(List<MarcaCocheEntity> marcaCocheEntityList);

}
