package com.example.buildingapi.client.fakestoreclient;

import com.example.buildingapi.exceptions.NotFoundException;
import com.example.buildingapi.models.Category;
import com.example.buildingapi.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public Optional<List<FakeStoreProductDto>> getAllProducts() throws NotFoundException {
        ResponseEntity<FakeStoreProductDto[]> responseEntity = requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products",
                null, FakeStoreProductDto[].class);
        List<FakeStoreProductDto> fakeStoreProductDtos = Arrays.asList(responseEntity.getBody());
        if(fakeStoreProductDtos.isEmpty()){
            throw new NotFoundException("No products found");
        }
        return Optional.of(fakeStoreProductDtos);
    }

    Optional<FakeStoreProductDto> getSingleProduct(Long productId) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> responseEntity = requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/{id}",
                null, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("No product with id " + productId);
        }
        return Optional.of(fakeStoreProductDto);
    }

    Optional<FakeStoreProductDto> addNewProduct(Product product) {
        ResponseEntity<FakeStoreProductDto> responseEntity = requestForEntity(HttpMethod.POST,"https://fakestoreapi.com/products",
                product, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        return Optional.of(fakeStoreProductDto);
    }

    /*
    Product object has only those fields filled which need to be updated.
    Everything else is null
     */
    Optional<FakeStoreProductDto> updateProduct(Long productId, Product product) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> responseEntity = requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id}",
                product, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("No product with id " + productId);
        }
        return Optional.of(fakeStoreProductDto);
    }

    Optional<FakeStoreProductDto> replaceProduct(Long productId, Product product) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> responseEntity = requestForEntity(HttpMethod.PUT,"https://fakestoreapi.com/products/{id}",
                product, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("No product with id " + productId);
        }
        return Optional.of(fakeStoreProductDto);
    }

    Optional<FakeStoreProductDto> deleteProduct(Long productId) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> responseEntity = requestForEntity(HttpMethod.DELETE,"https://fakestoreapi.com/products/{id}",
                null, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("No product with id " + productId);
        }
        return Optional.of(fakeStoreProductDto);
    }

    public Optional<List<FakeStoreCategoryDto>> getAllCategories() throws NotFoundException {
        ResponseEntity<FakeStoreCategoryDto[]> responseEntity = requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/categories",
                null, FakeStoreCategoryDto[].class);
        List<FakeStoreCategoryDto> fakeStorecategoryDtos = Arrays.asList(responseEntity.getBody());
        if(fakeStorecategoryDtos.isEmpty()){
            throw new NotFoundException("No categories found");
        }
        return Optional.of(fakeStorecategoryDtos);
    }

    public Optional<List<FakeStoreProductDto>> getProductsInCategory(String category) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto[]> responseEntity = requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/category/{$category}",
                null, FakeStoreProductDto[].class, category);
        List<FakeStoreProductDto> fakeStorecategoryDtos = Arrays.asList(responseEntity.getBody());
        if(fakeStorecategoryDtos.isEmpty()){
            throw new NotFoundException("No products found in caegory " + category);
        }
        return Optional.of(fakeStorecategoryDtos);
    }
}
