package com.example.buildingapi.client.fakestoreclient;

import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.services.CategoryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
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
    public Optional<List<String>> getAllCategoryNames() throws NotFoundException {
        Optional<List<FakeStoreCategoryDto>> categories = fakeStoreClient.getAllCategories();
        List<String> categoryList = new ArrayList<>();
        for (FakeStoreCategoryDto category : categories.get()){
            categoryList.add(category.getName());
        }
        return Optional.of(categoryList);
    }

    @Override
    public Optional<List<Product>> getProductsInCategory(String categoryName) throws NotFoundException {
        Optional<List<FakeStoreProductDto>> fakeStoreProductsDto = fakeStoreClient.getProductsInCategory(categoryName);
        if(fakeStoreProductsDto.isEmpty()){
            throw new NotFoundException("No products in category " + categoryName);
        }
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductsDto.get()){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return Optional.of(products);
    }
}
