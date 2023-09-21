package com.project.concesionaria.persistence.repository;

import com.project.concesionaria.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {
    List<PurchaseEntity> findAllByCardIdCustomer(String id);
}
