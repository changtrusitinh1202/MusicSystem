package com.example.product.service;


import com.example.product.entity.Singer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<Singer> getAllUser();
}
