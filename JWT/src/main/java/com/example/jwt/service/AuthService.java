package com.example.jwt.service;


import com.example.jwt.Repostory.JwtRequest;
import com.example.jwt.Repostory.JwtResponse;
import com.example.jwt.Repostory.RefreshTokenRequest;
import com.example.jwt.entity.SignupDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    JwtResponse signup(SignupDto dto);
    JwtResponse signin(JwtRequest request);
    JwtResponse refreshToken(RefreshTokenRequest request);
//    JwtResponse forgotPassword(String username);
//    String resetPassword(String token, String pass);
}

