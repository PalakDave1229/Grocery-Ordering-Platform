package com.grocery.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private Long id;
    private String name;
    private String description;
    private String unit;       // e.g. "1kg"
    private int price;
    private String shelfLife;
    private int stockQuantity;
}
