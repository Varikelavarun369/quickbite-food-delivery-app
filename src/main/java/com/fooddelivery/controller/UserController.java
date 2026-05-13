package com.fooddelivery.controller;

import com.fooddelivery.dto.UserRequestDto;
import com.fooddelivery.dto.UserResponseDto;
import com.fooddelivery.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public UserResponseDto saveUser(

            @Valid
            @RequestBody UserRequestDto requestDto) {

        return userService.saveUser(requestDto);
    }


    @GetMapping
    public List<UserResponseDto> getAllUsers() {

        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserResponseDto getUserById(
            @PathVariable Long id) {

        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public UserResponseDto updateUser(
            @PathVariable Long id,

            @Valid
            @RequestBody UserRequestDto requestDto) {

        return userService.updateUser(id, requestDto);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id) {

        return userService.deleteUser(id);
    }
}