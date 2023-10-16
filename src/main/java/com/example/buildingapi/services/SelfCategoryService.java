package com.example.buildingapi.services;

import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.repositories.CategoryRepository;
import com.example.buildingapi.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SelfCategoryService implements CategoryService{

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<List<String>> getAllCategoryNames() throws NotFoundException {
        List<Category> categories = categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<>();
        for(Category category : categories){
            categoryNames.add(category.getName());
        }
        return Optional.of(categoryNames);
    }

    @Override
    public Optional<List<Product>> getProductsInCategory(String categoryName) throws NotFoundException {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return Optional.of(categoryRepository.findProductsByCategoryId(category.getId()));
    }
}
