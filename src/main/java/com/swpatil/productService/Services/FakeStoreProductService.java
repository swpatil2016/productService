package com.swpatil.productService.Services;

import com.swpatil.productService.dtos.FakeStoreProductDto;
import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                                                    "https://fakestoreapi.com/products/{id}",
                                                    FakeStoreProductDto.class,
                                                    id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return null;
    }
}
