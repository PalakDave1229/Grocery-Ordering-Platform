package com.grocery.orderservice.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private int price; // subtotal or unit price (depending on your calculation strategy)
}
