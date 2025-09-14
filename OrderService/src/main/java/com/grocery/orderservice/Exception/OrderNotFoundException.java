package com.grocery.orderservice.Exception;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
