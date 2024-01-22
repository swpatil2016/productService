package com.swpatil.productService.Services;

import com.swpatil.productService.dtos.GenericProductDto;

public interface ProductService {

    public GenericProductDto getProductById(Long id);
}
