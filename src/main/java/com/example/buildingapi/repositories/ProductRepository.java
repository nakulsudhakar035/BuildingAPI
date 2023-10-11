package com.example.buildingapi.repositories;

import com.example.buildingapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);
    @Override
    List<Product> findAll();
    @Override
    Optional<Product> findById(Long aLong);
}
