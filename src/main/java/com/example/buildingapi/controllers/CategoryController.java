package com.example.buildingapi.controllers;

import com.example.buildingapi.exceptions.NotFoundException;
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
import java.util.Optional;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<String> getAllCategories() throws NotFoundException {
        Optional<List<String>> categories = categoryService.getAllCategoryNames();
        if (categories.isEmpty()) {
            throw new NotFoundException("No categories found");
        }
        ResponseEntity<List<String>> response = new ResponseEntity<>(categories.get(), HttpStatus.OK);
        return response.getBody();
    }

    @GetMapping("/{category}")
    public List<Product> getProductsInCategory(@PathVariable("category") String category) throws NotFoundException {
        Optional<List<Product>> products = categoryService.getProductsInCategory(category);
        if (products.isEmpty()) {
            throw new NotFoundException("No Products in category "+category);
        }
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products.get(), HttpStatus.OK);
        return response.getBody();
    }
}
