package com.swpatil.productService.Services;

import com.swpatil.productService.ThirdPartyClient.Dtos.FakeStoreProductDto;
import com.swpatil.productService.ThirdPartyClient.FakeStoreProductServiceClient;
import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Primary
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    public GenericProductDto convertFakeStoreDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        return convertFakeStoreDtoToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return convertFakeStoreDtoToGenericProductDto(fakeStoreProductServiceClient.createProduct(productDto));
    }
    @Override
    public List<GenericProductDto> getAllProduct() {
       List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductServiceClient.getAllProduct();
       List<GenericProductDto> genericProductDtos = new ArrayList<>();
       for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
           genericProductDtos.add(convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto));
       }
       return genericProductDtos;
    }
    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakeStoreDtoToGenericProductDto(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
