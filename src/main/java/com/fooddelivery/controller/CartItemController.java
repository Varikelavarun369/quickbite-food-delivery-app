package com.fooddelivery.controller;

import com.fooddelivery.dto.CartItemRequestDto;
import com.fooddelivery.dto.CartItemResponseDto;
import com.fooddelivery.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;


    @PostMapping
    public CartItemResponseDto saveCartItem(

            @Valid
            @RequestBody CartItemRequestDto requestDto) {

        return cartItemService.saveCartItem(
                requestDto);
    }


    @GetMapping
    public List<CartItemResponseDto>
    getAllCartItems() {

        return cartItemService.getAllCartItems();
    }


    @GetMapping("/{id}")
    public CartItemResponseDto
    getCartItemById(
            @PathVariable Long id) {

        return cartItemService.getCartItemById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteCartItem(
            @PathVariable Long id) {

        return cartItemService.deleteCartItem(id);
    }


    @GetMapping("/cart/{cartId}")
    public List<CartItemResponseDto>
    getCartItemsByCartId(
            @PathVariable Long cartId) {

        return cartItemService
                .getCartItemsByCartId(cartId);
    }


    @GetMapping("/cart/{cartId}/total")
    public Double calculateCartTotal(
            @PathVariable Long cartId) {

        return cartItemService
                .calculateCartTotal(cartId);
    }


    @PutMapping("/{id}")
    public CartItemResponseDto
    updateCartItem(
            @PathVariable Long id,

            @Valid
            @RequestBody
            CartItemRequestDto requestDto) {

        return cartItemService
                .updateCartItem(id, requestDto);
    }
}