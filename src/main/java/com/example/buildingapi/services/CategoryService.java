package com.example.buildingapi.services;

import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<String>> getAllCategoryNames() throws NotFoundException;

    Optional<List<Product>> getProductsInCategory(String categoryName) throws NotFoundException;
}
