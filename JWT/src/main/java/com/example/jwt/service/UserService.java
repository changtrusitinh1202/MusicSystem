package com.example.jwt.service;

import com.example.jwt.entity.ERole;
import com.example.jwt.entity.User;
import com.example.jwt.entity.UserStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUserName(String username);

    List<User> findAll();
    UserDetailsService userDetailsService();

}

