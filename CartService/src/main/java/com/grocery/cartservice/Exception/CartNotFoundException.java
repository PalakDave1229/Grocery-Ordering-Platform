package com.grocery.cartservice.Exception;

import lombok.Getter;

@Getter
public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String message) {
        super(message);
    }
}
