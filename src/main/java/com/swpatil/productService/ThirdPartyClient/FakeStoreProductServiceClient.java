package com.swpatil.productService.ThirdPartyClient;

import com.swpatil.productService.ThirdPartyClient.Dtos.FakeStoreProductDto;
import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductServiceClient {

    private String fakeStoreApiBaseUrl;
    private String productUrl;

    private String productPath = "/product"; // we can also do this.


    private String url = fakeStoreApiBaseUrl + productPath + "{id}";
    private String productRequestUrl = fakeStoreApiBaseUrl + productPath;

    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakeStore.API.url}") String fakeStoreApiBaseUrl,
                                         @Value("${product}") String productUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiBaseUrl = fakeStoreApiBaseUrl;
        this.productUrl = productUrl;
    }

    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                url,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;

    }

    public FakeStoreProductDto createProduct(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate
                .postForEntity(
                        productRequestUrl,
                        productDto,
                        FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(
                        productRequestUrl,
                        FakeStoreProductDto[].class); // Try to use list and ParameterizedTypeReference<List<FakeStoreProductDto>>
        FakeStoreProductDto[] fakeStoreProductDtos =  responseEntity.getBody();
        return Arrays.asList(fakeStoreProductDtos);
    }

    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
                .exchange(url, HttpMethod.DELETE, null, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        return fakeStoreProductDto;
    }

}
