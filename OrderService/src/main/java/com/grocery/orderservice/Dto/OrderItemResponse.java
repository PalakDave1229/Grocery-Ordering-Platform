package com.grocery.orderservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {
    private Long productId;
    private int quantity;
    private int price;
}