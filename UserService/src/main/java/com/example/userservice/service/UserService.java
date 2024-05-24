package com.example.userservice.service;

import com.example.userservice.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     Users findById(Long id);
     Users createUser(Users users);

}
