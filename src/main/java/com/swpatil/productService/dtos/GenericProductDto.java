package com.swpatil.productService.dtos;

import com.swpatil.productService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private Category category;
    private double price;
    private String description;
    private String image;
}
