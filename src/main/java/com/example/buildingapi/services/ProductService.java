package com.example.buildingapi.services;

import com.example.buildingapi.client.fakestoreclient.FakeStoreProductDto;
import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<List<Product>> getAllProducts() throws NotFoundException;

    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;

    Optional<Product> addNewProduct(Product product);

    Optional<Product> updateProduct(Long productId, Product product) throws NotFoundException;

    Optional<Product> deleteProduct(Long productId) throws NotFoundException;

}
