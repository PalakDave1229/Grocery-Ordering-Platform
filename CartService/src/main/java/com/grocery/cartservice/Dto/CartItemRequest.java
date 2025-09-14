package com.grocery.cartservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {
    private Long id;          // ID of the cart item (for update/delete)
    private Long cartId;      // ID of the cart it belongs to
    private Long productId;   // Product ID
    private int quantity;
    private int price;
}
