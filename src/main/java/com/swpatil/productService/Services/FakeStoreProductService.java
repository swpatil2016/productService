package com.swpatil.productService.Services;

import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("calling from Fake product");
        return null;
    }
}
