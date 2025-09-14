package com.grocery.cartservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {
    private Long id;
    private Long userId;
    private Double totalPrice;

}
