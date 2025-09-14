package com.grocery.userservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponse {
    private String userId;

    private String email;

    private String role;
}
