package com.grocery.userservice.Exception;

import lombok.Getter;

@Getter
public class UserNotFound extends RuntimeException {

    private String message;
    public UserNotFound(String message){
        this.message = message;
    }
}
