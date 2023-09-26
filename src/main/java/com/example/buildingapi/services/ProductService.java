package com.example.buildingapi.services;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(ProductDTO productDto);

    String updateProduct(Long productId, ProductDTO productDto);

    String deleteProduct(Long productId);

}
