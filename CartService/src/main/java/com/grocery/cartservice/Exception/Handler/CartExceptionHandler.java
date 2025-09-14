package com.grocery.cartservice.Exception.Handler;

import com.grocery.cartservice.Exception.CartNotFoundException;
import com.grocery.cartservice.Utility.ResponseBuilder;
import com.grocery.cartservice.Utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleCartNotFound(CartNotFoundException e) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
