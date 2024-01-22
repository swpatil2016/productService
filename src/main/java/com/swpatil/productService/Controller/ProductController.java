package com.swpatil.productService.Controller;

import com.swpatil.productService.Services.ProductService;
import com.swpatil.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id); // call method of service
    }















    @GetMapping()
    public void getAllProduct(){}
    public void updateProductById(){}
    @PostMapping()
    public void createProduct(){}
}
