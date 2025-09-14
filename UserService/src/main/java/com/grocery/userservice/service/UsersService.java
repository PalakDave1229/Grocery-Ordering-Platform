package com.grocery.userservice.service;

import com.grocery.userservice.dto.request.UsersRequest;
import com.grocery.userservice.dto.response.UsersResponse;
import com.grocery.userservice.model.Users;

import java.util.List;
import java.util.Map;

public interface UsersService {

    UsersResponse createUser(UsersRequest usersRequest);

    UsersResponse findById(String userId);

    List<UsersResponse> getAllUsers();

    UsersResponse getUserProfile(String uid);

    // Firebase-related
    Map<String, Object> signupWithFirebase(String email, String password);
    Map<String, Object> loginWithFirebase(String email, String password);
    UsersResponse getOrCreateUser(String uid, String email);
    UsersResponse setUserRole(String userId, String role);
}
