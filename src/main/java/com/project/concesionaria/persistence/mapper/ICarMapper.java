package com.project.concesionaria.persistence.mapper;

import com.project.concesionaria.domain.dto.CarDto;
import com.project.concesionaria.persistence.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto mapToCarDto(CarEntity carEntity);
    @Mapping(target = "brandCarEntity", ignore = true) //ignoramos en el mapeo la relacion porque no exite en el dto
    CarEntity mapToCarEntity(CarDto carDto);

    List<CarDto> toCarDto(List<CarEntity> carEntityList);


}
