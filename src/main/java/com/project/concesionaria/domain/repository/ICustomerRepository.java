package com.project.concesionaria.domain.repository;

import com.project.concesionaria.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    /**
     * Devuelve una lista con todas los clientes
     * @return Lista con clientes
     */
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomer);

    void delete(String cardId);
}
