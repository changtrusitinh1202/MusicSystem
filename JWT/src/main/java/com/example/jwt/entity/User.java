package com.example.jwt.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private ERole role;
    private UserStatus status;

    public User(UserDto user) {
        this.id = user.getId();
        this.role=user.getRole();
        this.password=user.getPassword();
        this.status=user.getStatus();
    }
}
