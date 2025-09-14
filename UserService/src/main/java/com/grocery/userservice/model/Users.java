package com.grocery.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users") // Table name in the database
@Getter
@Setter
public class Users {

    @Id
    @Column(name = "user_id")
    private String userId = UUID.randomUUID().toString();

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;
}
