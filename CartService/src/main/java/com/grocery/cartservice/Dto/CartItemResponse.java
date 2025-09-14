package com.grocery.cartservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemResponse {

    private Long id;
    private Long cartId;
    private Long productId;
    private int quantity;
    private int price;
}
