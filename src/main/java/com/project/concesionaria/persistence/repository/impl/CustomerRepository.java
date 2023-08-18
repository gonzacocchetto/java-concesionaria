package com.project.concesionaria.persistence.repository.impl;

import com.project.concesionaria.domain.dto.CustomerDto;
import com.project.concesionaria.domain.dto.ResponseCustomerDto;
import com.project.concesionaria.domain.repository.ICustomerRepository;
import com.project.concesionaria.persistence.entity.CustomerEntity;
import com.project.concesionaria.persistence.mapper.ICustomerMapper;
import com.project.concesionaria.persistence.repository.ICustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerCrudRepository.findById(cardId).map(iCustomerMapper::mapToCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email).map(iCustomerMapper::mapToCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        CustomerEntity customer = iCustomerMapper.mapToCustomerEntity(newCustomer);
        return iCustomerMapper.mapToCustomerDto(iCustomerCrudRepository.save(customer));
    }

    @Override
    public void delete(String cardId) {
        iCustomerCrudRepository.deleteById(cardId);

    }
}
