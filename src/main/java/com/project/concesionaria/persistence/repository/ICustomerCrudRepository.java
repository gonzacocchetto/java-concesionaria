package com.project.concesionaria.persistence.repository;

import com.project.concesionaria.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findeByEmail(String email);
}
