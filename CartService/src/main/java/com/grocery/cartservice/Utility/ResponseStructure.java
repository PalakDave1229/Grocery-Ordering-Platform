package com.grocery.cartservice.Utility;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;
}
