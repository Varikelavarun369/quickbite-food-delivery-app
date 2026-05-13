package com.fooddelivery.service;

import com.fooddelivery.dto.CartRequestDto;
import com.fooddelivery.dto.CartResponseDto;
import com.fooddelivery.entity.Cart;
import com.fooddelivery.entity.User;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.CartRepository;
import com.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public CartResponseDto saveCart(
            CartRequestDto requestDto) {

        Cart cart =
                convertToEntity(requestDto);

        Cart savedCart =
                cartRepository.save(cart);

        return convertToDto(savedCart);
    }


    public List<CartResponseDto> getAllCarts() {

        List<Cart> carts =
                cartRepository.findAll();

        List<CartResponseDto> dtoList =
                new ArrayList<>();

        for (Cart cart : carts) {

            dtoList.add(convertToDto(cart));
        }

        return dtoList;
    }


    public CartResponseDto getCartById(Long id) {

        Cart cart =
                cartRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found with id: " + id));

        return convertToDto(cart);
    }

    public String deleteCart(Long id) {

        Cart cart =
                cartRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found with id: " + id));

        cartRepository.delete(cart);

        return "Cart deleted successfully";
    }


    public Cart convertToEntity(
            CartRequestDto dto) {

        Cart cart = new Cart();

        User user =
                userRepository.findById(
                                dto.getUserId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with id: "
                                                + dto.getUserId()));

        cart.setUser(user);

        return cart;
    }

    public CartResponseDto convertToDto(
            Cart cart) {

        CartResponseDto dto =
                new CartResponseDto();

        dto.setId(cart.getId());

        dto.setUserName(
                cart.getUser().getName());

        return dto;
    }

    public CartResponseDto
    getCartByUserId(Long userId) {

        Cart cart =
                cartRepository.findByUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found for user id: "
                                                + userId));

        return convertToDto(cart);
    }
}