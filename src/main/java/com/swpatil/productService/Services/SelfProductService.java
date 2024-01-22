package com.swpatil.productService.Services;

import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("Calling from self product");
        return null;
    }
}
