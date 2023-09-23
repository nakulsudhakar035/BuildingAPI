package com.example.buildingapi.services;

import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @Override
    public List<Product> getProductsInCategory(Long categoryId) {
        return new ArrayList<>();
    }
}
