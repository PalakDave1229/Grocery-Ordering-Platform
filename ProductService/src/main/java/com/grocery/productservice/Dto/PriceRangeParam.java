package com.grocery.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRangeParam {
    private int minPrice;
    private int maxPrice;
}
