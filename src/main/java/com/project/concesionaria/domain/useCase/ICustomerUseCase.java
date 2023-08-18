package com.project.concesionaria.domain.useCase;

import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface der servicio de cliente
 */
public interface ICustomerUseCase {
    /**
     * Devuelve una lista con todas los clientes
     * @return Lista con clientes
     */
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    ResponseCustomerDto save(CustomerDto customerDto);

    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    boolean delete(String cardId);
}
