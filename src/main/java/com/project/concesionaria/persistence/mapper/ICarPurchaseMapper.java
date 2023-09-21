package com.project.concesionaria.persistence.mapper;

import com.project.concesionaria.domain.dto.CarPurchaseRequestDto;
import com.project.concesionaria.persistance.entity.CarPurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper de coches compras
 */
@Mapper(componentModel = "spring")
public interface ICarPurchaseMapper {

    @Mapping(source = "codeCar", target = "id.codeCar")
    @Mapping(target = "purchaseEntity", ignore = true)
    @Mapping(target = "carEntity", ignore = true)
    @Mapping(target = "id.purchaseNumberBill", ignore = true)
    CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto);
}
