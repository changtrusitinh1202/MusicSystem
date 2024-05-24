package com.example.userservice.controller;

import com.example.userservice.entity.Users;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    private Users GetById(@PathVariable  Long id){
        return userService.findById(id);
    }
    @PostMapping("/save")
    private  Users save(@RequestBody Users users){
        return userService.createUser(users);
    }

}
