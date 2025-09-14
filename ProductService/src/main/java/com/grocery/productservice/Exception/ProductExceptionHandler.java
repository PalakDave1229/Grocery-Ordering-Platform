package com.grocery.productservice.Exception;


import com.grocery.productservice.Utility.ResponseBuilder;
import com.grocery.productservice.Utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    ResponseEntity<SimpleErrorResponse> productNotFoundHandler(ProductNotFoundException e) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, e.getMessage());
    }
}

