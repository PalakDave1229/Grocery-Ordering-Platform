package com.grocery.userservice.controller;

import com.grocery.userservice.service.UsersService;
import com.grocery.userservice.utility.ResponseBuilder;
import com.grocery.userservice.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AuthController {

    private final UsersService usersService;

    @PostMapping("/auth/signup")
    public ResponseEntity<ResponseStructure<Map<String, Object>>> signup(
            @RequestBody Map<String, String> signupRequest) {
        String email = signupRequest.get("email");
        String password = signupRequest.get("password");
        Map<String, Object> responseData = usersService.signupWithFirebase(email, password);
        return ResponseBuilder.success(HttpStatus.CREATED, "Signup successful", responseData);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ResponseStructure<Map<String, Object>>> login(
            @RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        Map<String, Object> responseData = usersService.loginWithFirebase(email, password);
        return ResponseBuilder.success(HttpStatus.OK, "Login successful", responseData);
    }
}
