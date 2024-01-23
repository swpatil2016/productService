package com.swpatil.productService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String category;// for make simple take string
    private double price;
    private String description;
    private String image;
}
