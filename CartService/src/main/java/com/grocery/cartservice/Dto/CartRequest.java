package com.grocery.cartservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private Long id;
    private Long userId;
    private Double totalPrice;
}
