package com.grocery.userservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequest {

    private String email;

    private String role;
}
