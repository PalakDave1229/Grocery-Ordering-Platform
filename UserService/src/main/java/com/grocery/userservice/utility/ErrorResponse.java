package com.grocery.userservice.utility;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ErrorResponse {
    private String errorType;
    private int status; // 404
    private String message; // failed to update the user, The user is not found by the given id
    private String path;

}
