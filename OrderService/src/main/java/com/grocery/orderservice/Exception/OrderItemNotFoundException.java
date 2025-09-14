package com.grocery.orderservice.Exception;

import lombok.Getter;

@Getter
public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(String message) {
        super(message);
    }
}
