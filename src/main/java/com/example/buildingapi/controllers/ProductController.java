package com.example.buildingapi.controllers;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.exceptions.ProductNotCreatedException;
import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() throws NotFoundException {
        Optional<List<Product>> products = productService.getAllProducts();
        if (products.isEmpty()) {
            throw new NotFoundException("No Products found");
        }
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products.get(), HttpStatus.OK);
        return response.getBody();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        Optional<Product> productOptional = productService.getSingleProduct(productId);
        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }

        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                null,
                HttpStatus.OK
        );

        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO productDto) throws ProductNotCreatedException {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        Optional<Product> newProduct = productService.addNewProduct(product);
        if(newProduct.isEmpty()){
            throw new ProductNotCreatedException("Could not create product");
        }
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct.get(), HttpStatus.OK);
        return response;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDto) throws NotFoundException {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        Optional<Product> updatedProduct = productService.updateProduct(productId, product);
        ResponseEntity<Product> response = new ResponseEntity<>(updatedProduct.get(), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        Optional<Product> updatedProduct = productService.deleteProduct(productId);
        ResponseEntity<Product> response = new ResponseEntity<>(updatedProduct.get(), HttpStatus.OK);
        return response;
    }
}
