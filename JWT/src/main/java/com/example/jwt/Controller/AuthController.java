package com.example.jwt.Controller;


import com.example.jwt.Repostory.JwtRequest;
import com.example.jwt.Repostory.JwtResponse;
import com.example.jwt.Repostory.RefreshTokenRequest;
import com.example.jwt.entity.SignupDto;

import com.example.jwt.service.AuthService;
import com.example.jwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Qualifier("authServiceImpl")
    @Autowired
    private AuthService service;
    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody SignupDto dto) {
        return ResponseEntity.ok(service.signup(dto));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@RequestBody JwtRequest dto) {
        return ResponseEntity.ok(service.signin(dto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(service.refreshToken(request));
    }
}

//    @PostMapping("/password/forgot")
//    @Operation(summary = "Quên mật khẩu")
//    public ResponseEntity<JwtResponse> forgotPassword(@RequestBody @Valid UsernameDto dto) {
//        return ResponseEntity.ok(service.forgotPassword(dto.getUsername()));
//    }
//
//    @PostMapping("/password/reset")
//    @Operation(summary = "Đổi mật khẩu")
//    public ResponseEntity<String> resetPassword(@RequestBody @Valid ResetPassDto dto) {
//        return ResponseEntity.ok(service.resetPassword(dto.getToken(), dto.getPassword()));
//    }
//}