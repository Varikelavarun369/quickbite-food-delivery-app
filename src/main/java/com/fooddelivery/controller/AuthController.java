package com.fooddelivery.controller;

import com.fooddelivery.dto.AuthResponseDto;
import com.fooddelivery.dto.LoginRequestDto;

import com.fooddelivery.entity.User;

import com.fooddelivery.repository.UserRepository;

import com.fooddelivery.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager
            authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")

    public AuthResponseDto login(

            @RequestBody
            LoginRequestDto requestDto) {

        Authentication authentication =

                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(

                                requestDto.getEmail(),

                                requestDto.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {

            String token =
                    jwtService.generateToken(
                            requestDto.getEmail());

            User user =
                    userRepository.findByEmail(
                                    requestDto.getEmail())
                            .orElse(null);

            return new AuthResponseDto(

                    token,

                    user.getId(),

                    user.getRole()
            );
        }

        return null;
    }
}