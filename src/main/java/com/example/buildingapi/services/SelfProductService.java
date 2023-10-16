package com.example.buildingapi.services;

import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<List<Product>> getAllProducts() throws NotFoundException {
        return Optional.of(productRepository.findAll());
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<Product> addNewProduct(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> updateProduct(Long productId, Product product) throws NotFoundException {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) throws NotFoundException {
        Optional<Product> product = getSingleProduct(productId);
        productRepository.delete(product.get());
        return product;
    }
}
