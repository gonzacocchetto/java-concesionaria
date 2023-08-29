package com.project.concesionaria.persistence.mapper;

import com.project.concesionaria.domain.dto.PurchaseRequestDto;
import com.project.concesionaria.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper de compras
 */
@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto mapToPurchaseDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity mapToPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchasesDto(List<PurchaseEntity> purchaseEntityList);


}
