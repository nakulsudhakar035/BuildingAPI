package com.example.buildingapi.services;

import com.example.buildingapi.dtos.CategoryDTO;
import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private RestTemplateBuilder restTemplateBuilder;
    public CategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<String> getAllCategories() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );


        return Arrays.stream(responseEntity.getBody()).toList();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories/{category}",
                ProductDTO[].class, categoryName );
        List<Product> products = new ArrayList<>();
        for(ProductDTO productDTO: responseEntity.getBody()){
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setTitle(productDTO.getTitle());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            Category category = new Category();
            category.setName(productDTO.getCategory());
            product.setCategory(category);
            product.setImageUrl(productDTO.getImage());
            products.add(product);
        }

        return products;
    }
}
