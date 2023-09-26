package com.example.buildingapi.services;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductDTO[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDTO[].class
        );
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

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response =  restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                ProductDTO.class, productId);

        ProductDTO productDto = response.getBody();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());

        return product;
    }

    @Override
    public Product addNewProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                productDTO,
                ProductDTO.class
        );

        ProductDTO productDto = response.getBody();

        Product newProduct = new Product();
        newProduct.setId(productDto.getId());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        newProduct.setCategory(category);
        newProduct.setImageUrl(productDto.getImage());
        return newProduct;
    }

    @Override
    public String updateProduct(Long productId, ProductDTO productDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        /*restTemplate.put(
                "https://fakestoreapi.com/products/{id}",
                productDto,
                productId
        );
        Product newProduct = new Product();
        newProduct.setId(productDto.getId());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        newProduct.setCategory(category);
        newProduct.setImageUrl(productDto.getImage());
        return newProduct;*/

        /*ResponseEntity<Product> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/"+productId,
                HttpMethod.PUT,
                new HttpEntity<>(productDto, new HttpHeaders()),
                Product.class);*/

        /*
        ResponseEntity<Product> response = restTemplate.exchange(
                "https://fakestoreapi.com/products/{pID}",
                HttpMethod.PUT,
                request,
                Product.class);
         */

        HttpEntity<ProductDTO> request = new HttpEntity<ProductDTO>(productDto);
        Map<String, Long> params = new HashMap<>();
        params.put("id", productId);
        restTemplate.put("https://fakestoreapi.com/products/{id}", productDto, params);

        return "Product updated";

    }

    @Override
    public String deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(
                "https://fakestoreapi.com/products/{id}",
                productId);
        return "Product deleted";
    }
}
