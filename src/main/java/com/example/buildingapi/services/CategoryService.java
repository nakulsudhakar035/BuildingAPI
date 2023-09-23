package com.example.buildingapi.services;

import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Product> getProductsInCategory(Long categoryId);
}
