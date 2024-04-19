package com.example.product.controller;



import com.example.product.entity.Singer;
import com.example.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/singer")
@RequiredArgsConstructor
public class SingerController {
    @Autowired
    UserService userService;

    @GetMapping("/singer")
    public List<Singer> getUser() {
        return userService.getAllUser();
    }
}
