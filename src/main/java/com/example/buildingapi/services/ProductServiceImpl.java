package com.example.buildingapi.services;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public String addNewProduct(ProductDTO productDto) {
        return "Created product with  details "+productDto+" successfully";
    }

    @Override
    public String updateProduct(Long productId, ProductDTO productDto) {
        return "Updated product with id: " + productId + "and details "+productDto+" successfully";
    }

    @Override
    public String deleteProduct(Long productId) {
        return "Deleted product with id: " + productId + " successfully";
    }
}
