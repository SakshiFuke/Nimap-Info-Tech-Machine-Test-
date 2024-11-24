package com.NimapInfoTechAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapInfoTechAssessment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
