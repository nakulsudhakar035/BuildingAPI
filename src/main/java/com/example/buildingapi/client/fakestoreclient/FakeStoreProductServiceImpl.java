package com.example.buildingapi.client.fakestoreclient;

import com.example.buildingapi.dtos.ProductDTO;
import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import com.example.buildingapi.services.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
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
    public Optional<List<Product>> getAllProducts() throws NotFoundException {
        Optional<List<FakeStoreProductDto>> fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos.get()){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return Optional.of(products);
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);
        if(fakeStoreProductDto.isEmpty()){
            throw new NotFoundException("No product with id " + productId);
        }
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
    }

    @Override
    public Optional<Product> addNewProduct(Product product) {
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.addNewProduct(product);
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
    }

    @Override
    public Optional<Product> updateProduct(Long productId, Product product) throws NotFoundException {
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.updateProduct(productId, product);
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) throws NotFoundException {
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.deleteProduct(productId);
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
    }
}
