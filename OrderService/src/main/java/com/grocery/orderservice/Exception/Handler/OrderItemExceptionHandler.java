package com.grocery.orderservice.Exception.Handler;


import com.grocery.orderservice.Exception.OrderItemNotFoundException;
import com.grocery.orderservice.Utility.ResponseBuilder;
import com.grocery.orderservice.Utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderItemExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleOrderItemNotFound(OrderItemNotFoundException e) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
