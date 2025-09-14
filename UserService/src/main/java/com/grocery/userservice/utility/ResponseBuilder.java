package com.grocery.userservice.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(structure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status)
                .headers(headers)
                .body(structure);
    }

    public static <T> ResponseEntity<ListResponseStructure<T>> success(HttpStatus status, String message, List<T> data) {
        ListResponseStructure<T> listResponseStructure = ListResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(listResponseStructure);
    }


    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .build();

        return ResponseEntity.status(status)
                .headers(headers)
                .body(structure);
    }

    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }

    // 👇 Utility method for reuse in other places
    public static ResponseEntity<ErrorResponse> uncheckError(HttpStatus status, String message, String path) {
        ErrorResponse error = ErrorResponse.builder()
                .errorType(status.name())
                .message(message)
                .status(status.value())
                .path(path)
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
