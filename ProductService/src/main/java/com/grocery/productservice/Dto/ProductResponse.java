package com.grocery.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private long id;
    private String name;
    private String description;
    private String unit;
    private int price;
    private String shelfLife;
    private int stockQuantity;
}
