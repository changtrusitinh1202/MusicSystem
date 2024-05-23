package com.example.jwt.service;


import com.example.jwt.Repostory.JwtRequest;
import com.example.jwt.Repostory.JwtResponse;
import com.example.jwt.Repostory.RefreshTokenRequest;
import com.example.jwt.Repostory.UserRepository;
import com.example.jwt.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@Component
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    @Override
    public JwtResponse signup(SignupDto dto) {
        Optional<User> opUser = repository.findByUsername(dto.getUsername());
        if (opUser.isEmpty()) {
            User u = new User();
            u.setUsername(dto.getUsername());
            u.setRole(ERole.USER);
            u.setPassword(passwordEncoder.encode(dto.getPassword()));
            u.setStatus(UserStatus.ACTIVE);
            User us = repository.save(u);
            JwtResponse r = signin(new JwtRequest(dto.getUsername(), dto.getPassword()));
            return r;
        } else {
            throw new RuntimeException("existedUser");
        }
    }

    @Override
    public JwtResponse signin(JwtRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = repository.findByUsername(request.getUsername()).orElseThrow(() -> new IllegalArgumentException("invalid username"));
        UserDto dto = new UserDto(user);
        var jwt = jwtService.generateToken(dto);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), dto);
        JwtResponse response = new JwtResponse();
        response.setAccessToken(jwt);
        response.setRefreshToken(refreshToken);
        return response;
    }

    @Override
    public JwtResponse refreshToken(RefreshTokenRequest request) {
        String userName = jwtService.extractUserName(request.getToken());
        User user = repository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("user is not existed!"));
        UserDto dto = new UserDto(user);
        if (jwtService.isTokenValid(request.getToken(), dto)) {
            var jwt = jwtService.generateToken(dto);
            JwtResponse response = new JwtResponse();
            response.setAccessToken(jwt);
            response.setRefreshToken(request.getToken());
            return response;
        }
        return null;
    }

//        @Override
//        public JwtResponse forgotPassword(String username) {
//            User user = repository.findByMssv(username).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản " + username));
//            if (user.getStatus() == UserStatus.LOCKED) {
//                throw new RuntimeException("Tài khoản " + username + " đã bị khóa.");
//            }
//            if (user.getStatus() != UserStatus.ACTIVE) {
//                throw new RuntimeException("Tài khoản " + user + " không sẵn sàng.");
//            }
//            var userdto = repository.findByMssv(username).orElseThrow(() -> new IllegalArgumentException("invalid username"));
//            UserDto dto = new UserDto(userdto);
//            var jwt = jwtService.generateToken(dto);
//            var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), dto);
//            JwtResponse response = new JwtResponse();
//            response.setAccessToken(jwt);
//            response.setRefreshToken(refreshToken);
//            return response;
//        }
//
//        @Override
//        public String resetPassword(String token, String pass) {
//            if (!jwtService.isTokenExprired(token)) {
//                String username = jwtService.extractUserName(token);
//                User user = repository.findByMssv(username).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy user " + username));
//                user.setPassword(passwordEncoder.encode(pass));
//                repository.save(user);
//                return "passUpdateSuccess";
//            }
//            throw new RuntimeException("passUpdateFailed");
//        }

}


