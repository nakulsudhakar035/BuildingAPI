package com.example.buildingapi.controllers;

import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<String> getAllCategories() {
        List<String> categories = categoryService.getAllCategories();
        ResponseEntity<List<String>> response = new ResponseEntity<>(categories, HttpStatus.OK);
        return response.getBody();
    }

    @GetMapping("/{categoryId}")
    public List<Product> getProductsInCategory(@PathVariable("categoryId") String category) {
        List<Product> products = categoryService.getProductsInCategory(category);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response.getBody();
    }
}
