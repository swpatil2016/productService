package com.swpatil.productService.Services;

import com.swpatil.productService.dtos.GenericProductDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProduct();

    public GenericProductDto deleteProduct(Long ig); // return type might be anything here. because of fake store
    //return the deleted object so we returning the GenericProductDto.
}
