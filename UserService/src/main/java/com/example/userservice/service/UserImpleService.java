package com.example.userservice.service;

import com.example.userservice.entity.Users;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserImpleService implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Users createUser(Users users) {
        return userRepository.save(users);
    }
}
