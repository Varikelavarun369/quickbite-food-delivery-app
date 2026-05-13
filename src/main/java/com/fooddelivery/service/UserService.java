package com.fooddelivery.service;

import com.fooddelivery.dto.UserRequestDto;
import com.fooddelivery.dto.UserResponseDto;
import com.fooddelivery.entity.User;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserResponseDto saveUser(
            UserRequestDto requestDto) {

        User user = convertToEntity(requestDto);

        User savedUser =
                userRepository.save(user);

        return convertToDto(savedUser);
    }


    public List<UserResponseDto> getAllUsers() {

        List<User> users =
                userRepository.findAll();

        List<UserResponseDto> dtoList =
                new ArrayList<>();

        for (User user : users) {

            dtoList.add(convertToDto(user));
        }

        return dtoList;
    }


    public UserResponseDto getUserById(Long id) {

        User user =
                userRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with id: " + id));

        return convertToDto(user);
    }


    public UserResponseDto updateUser(
            Long id,
            UserRequestDto requestDto) {

        User existingUser =
                userRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with id: " + id));

        existingUser.setName(requestDto.getName());
        existingUser.setEmail(requestDto.getEmail());
        existingUser.setPassword(requestDto.getPassword());
        existingUser.setRole(requestDto.getRole());

        User updatedUser =
                userRepository.save(existingUser);

        return convertToDto(updatedUser);
    }


    public String deleteUser(Long id) {

        User user =
                userRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with id: " + id));

        userRepository.delete(user);

        return "User deleted successfully";
    }


    public User convertToEntity(
            UserRequestDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(
                passwordEncoder.encode(
                        dto.getPassword()));
        user.setRole(dto.getRole());

        return user;
    }

    public UserResponseDto convertToDto(
            User user) {

        UserResponseDto dto =
                new UserResponseDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }
}