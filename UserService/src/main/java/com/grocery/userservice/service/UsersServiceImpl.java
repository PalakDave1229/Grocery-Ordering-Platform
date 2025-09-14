package com.grocery.userservice.service;

import com.grocery.userservice.Exception.UserNotFound;
import com.grocery.userservice.dto.request.UsersRequest;
import com.grocery.userservice.dto.response.UsersResponse;
import com.grocery.userservice.mapper.UsersMapper;
import com.grocery.userservice.model.Users;
import com.grocery.userservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;
    private final UsersMapper usersMapper;

    @Override
    public UsersResponse createUser(UsersRequest usersRequest) {
        Users users = usersMapper.mapToUser(usersRequest);
        repository.save(users);
        return usersMapper.mapToUserResponse(users);
    }

    @Override
    public UsersResponse findById(String userId) {
        Users users = repository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User not found with this id : " + userId));
        return usersMapper.mapToUserResponse(users);
    }

    @Override
    public List<UsersResponse> getAllUsers() {
        List<Users> users = repository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFound("Users not found, please try again!");
        }
        return usersMapper.mapToUserResponseList(users);
    }

    @Override
    public UsersResponse getUserProfile(String uid) {
        Users user = repository.findById(uid)
                .orElseThrow(() -> new UserNotFound("User not found with this id"));
        return usersMapper.mapToUserResponse(user);
    }

    // 🔹 Firebase Signup
    @Override
    public Map<String, Object> signupWithFirebase(String email, String password) {
        String apiKey = "AIzaSyAIuErClMr6C7FW7YG_TMi1-HMEs9kr-uU";
        String url = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + apiKey;

        Map<String, Object> request = new HashMap<>();
        request.put("email", email);
        request.put("password", password);
        request.put("returnSecureToken", true);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> firebaseResponse = restTemplate.postForObject(url, request, Map.class);

        String idToken = (String) firebaseResponse.get("idToken");
        String uid = (String) firebaseResponse.get("localId");

        UsersResponse userResponse = getOrCreateUser(uid, email);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("idToken", idToken);
        responseData.put("user", userResponse);

        return responseData;
    }

    // 🔹 Firebase Login
    @Override
    public Map<String, Object> loginWithFirebase(String email, String password) {
        String apiKey = "AIzaSyAIuErClMr6C7FW7YG_TMi1-HMEs9kr-uU";
        String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey;

        Map<String, Object> request = new HashMap<>();
        request.put("email", email);
        request.put("password", password);
        request.put("returnSecureToken", true);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> firebaseResponse = restTemplate.postForObject(url, request, Map.class);

        String idToken = (String) firebaseResponse.get("idToken");
        String uid = (String) firebaseResponse.get("localId");

        UsersResponse userResponse = getOrCreateUser(uid, email);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("idToken", idToken);
        responseData.put("user", userResponse);

        return responseData;
    }

    @Override
    public UsersResponse getOrCreateUser(String uid, String email) {
        Users user = repository.findById(uid).orElseGet(() -> {
            Users newUser = new Users();
            newUser.setUserId(uid);
            newUser.setEmail(email);
            newUser.setRole("ADMIN");
            return repository.save(newUser);
        });

        if (email != null && !email.equals(user.getEmail())) {
            user.setEmail(email);
            repository.save(user);
        }

        return usersMapper.mapToUserResponse(user);
    }

    @Override
    public UsersResponse setUserRole(String userId, String role) {
        Users user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User not found with id: " + userId));
        user.setRole(role);
        repository.save(user);
        return usersMapper.mapToUserResponse(user);
    }
}
