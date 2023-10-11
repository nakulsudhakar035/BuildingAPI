package com.example.buildingapi.repositories;

import com.example.buildingapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    @Override
    Optional<Category> findById(Long aLong);

    @Override
    List<Category> findAll();
}
