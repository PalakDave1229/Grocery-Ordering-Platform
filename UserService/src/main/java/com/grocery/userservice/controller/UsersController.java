package com.grocery.userservice.controller;

import com.grocery.userservice.dto.request.UsersRequest;
import com.grocery.userservice.dto.response.UsersResponse;
import com.grocery.userservice.service.UsersService;
import com.grocery.userservice.utility.ListResponseStructure;
import com.grocery.userservice.utility.ResponseBuilder;
import com.grocery.userservice.utility.ResponseStructure;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    // Create new user manually
    @PostMapping
    public ResponseEntity<ResponseStructure<UsersResponse>> createUsers(@RequestBody UsersRequest request){
        UsersResponse usersResponse = usersService.createUser(request);
        return ResponseBuilder.success(HttpStatus.CREATED,"User created successfully",usersResponse);
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UsersResponse>> findById(@PathVariable String userId){
        UsersResponse usersResponse = usersService.findById(userId);
        return ResponseBuilder.success(HttpStatus.OK,"User found successfully",usersResponse);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<ListResponseStructure<UsersResponse>> getAllUsers(){
        List<UsersResponse> responseList = usersService.getAllUsers();
        return ResponseBuilder.success(HttpStatus.OK,"List of users fetched successfully",responseList);
    }

    // Get profile of logged-in user
    @GetMapping("/me")
    public ResponseEntity<ResponseStructure<UsersResponse>> getMyProfile(HttpServletRequest request) {
        String uid = (String) request.getAttribute("uid");
        UsersResponse usersResponse = usersService.getUserProfile(uid);
        return ResponseBuilder.success(HttpStatus.OK, "User profile fetched successfully", usersResponse);
    }

    // Update role (ADMIN can promote/demote)
    @PutMapping("/{userId}/role")
    public ResponseEntity<ResponseStructure<UsersResponse>> updateRole(
            @PathVariable String userId,
            @RequestParam String role) {

        UsersResponse usersResponse = usersService.setUserRole(userId, role);
        return ResponseBuilder.success(HttpStatus.OK, "User role updated successfully", usersResponse);
    }
}
