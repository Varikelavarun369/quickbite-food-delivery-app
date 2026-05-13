package com.fooddelivery.controller;

import com.fooddelivery.dto.CartRequestDto;
import com.fooddelivery.dto.CartResponseDto;
import com.fooddelivery.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping
    public CartResponseDto saveCart(

            @Valid
            @RequestBody CartRequestDto requestDto) {

        return cartService.saveCart(requestDto);
    }

    @GetMapping
    public List<CartResponseDto> getAllCarts() {

        return cartService.getAllCarts();
    }


    @GetMapping("/{id}")
    public CartResponseDto getCartById(
            @PathVariable Long id) {

        return cartService.getCartById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteCart(
            @PathVariable Long id) {

        return cartService.deleteCart(id);
    }

    @GetMapping("/user/{userId}")

    public CartResponseDto
    getCartByUserId(
            @PathVariable Long userId) {

        return cartService
                .getCartByUserId(userId);
    }
}