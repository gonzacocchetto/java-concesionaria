package com.project.concesionaria.persistence.mapper;

import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper de cliente
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto mapToCustomerDto(CustomerEntity customerEntity);

    CustomerEntity mapToCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomerDto(List<CustomerEntity> customerEntityList);



}
