package com.example.buildingapi.controllers;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response.getBody();
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) {
        Product newProduct = productService.getSingleProduct(productId);
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response.getBody();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody ProductDTO productDto) {
        Product newProduct = productService.addNewProduct(productDto);
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response.getBody();
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDto) {
        String message = productService.updateProduct(productId, productDto);
        ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.OK);
        return response.getBody();
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        String message = productService.deleteProduct(productId);
        ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.OK);
        return response.getBody();
    }
}
