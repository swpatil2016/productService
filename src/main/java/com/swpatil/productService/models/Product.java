package com.swpatil.productService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel{
    private String title;
    private Category category;
    private double price;
    private String description;
    private String image;
}
