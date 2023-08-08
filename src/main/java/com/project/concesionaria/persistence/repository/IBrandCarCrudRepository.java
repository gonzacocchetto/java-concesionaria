package com.project.concesionaria.persistence.repository;

import com.project.concesionaria.persistence.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Long> {

}
