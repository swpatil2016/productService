package com.swpatil.productService.Controller;

import com.swpatil.productService.Services.ProductService;
import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;



    /* -> Field injection
    @Autowired
    ProductService productService;
    */
    // -> Constructor injection. This is more popular than field injection because of some points.
    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id); // call method of service
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @GetMapping
    public List<GenericProductDto> getAllProduct(){
        return productService.getAllProduct();
    }








    public void updateProductById(){}

}
