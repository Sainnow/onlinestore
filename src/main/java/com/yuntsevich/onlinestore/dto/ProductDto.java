package com.yuntsevich.onlinestore.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {

    private String name;

    private Long price;

    private String category;

    private String subcategory;

    private String description;

}
