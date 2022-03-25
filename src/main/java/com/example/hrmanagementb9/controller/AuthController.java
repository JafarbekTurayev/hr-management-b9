package com.example.hrmanagementb9.controller;

import com.example.hrmanagementb9.config.JwtProvider;
import com.example.hrmanagementb9.dto.LoginDTO;
import com.example.hrmanagementb9.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping( "/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
        String token = jwtProvider.generateToken(loginDTO.getUserName());


        return ResponseEntity.ok().body(token);

    }
}
