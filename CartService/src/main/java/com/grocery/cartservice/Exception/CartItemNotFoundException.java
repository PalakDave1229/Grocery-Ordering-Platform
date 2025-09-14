package com.grocery.cartservice.Exception;

import lombok.Getter;

@Getter
public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String message) {
        super(message);
    }
}
