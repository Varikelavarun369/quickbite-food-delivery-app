package com.fooddelivery.service;

import com.fooddelivery.dto.CartItemRequestDto;
import com.fooddelivery.dto.CartItemResponseDto;
import com.fooddelivery.entity.Cart;
import com.fooddelivery.entity.CartItem;
import com.fooddelivery.entity.FoodItem;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.CartItemRepository;
import com.fooddelivery.repository.CartRepository;
import com.fooddelivery.repository.FoodItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;


    public CartItemResponseDto saveCartItem(
            CartItemRequestDto requestDto) {

        CartItem cartItem =
                convertToEntity(requestDto);

        CartItem savedCartItem =
                cartItemRepository.save(cartItem);

        return convertToDto(savedCartItem);
    }


    public List<CartItemResponseDto>
    getAllCartItems() {

        List<CartItem> cartItems =
                cartItemRepository.findAll();

        List<CartItemResponseDto> dtoList =
                new ArrayList<>();

        for (CartItem cartItem : cartItems) {

            dtoList.add(
                    convertToDto(cartItem));
        }

        return dtoList;
    }


    public CartItemResponseDto
    getCartItemById(Long id) {

        CartItem cartItem =
                cartItemRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart item not found with id: "
                                                + id));

        return convertToDto(cartItem);
    }


    public String deleteCartItem(Long id) {

        CartItem cartItem =
                cartItemRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart item not found with id: "
                                                + id));

        cartItemRepository.delete(cartItem);

        return "Cart item deleted successfully";
    }


    public List<CartItemResponseDto>
    getCartItemsByCartId(Long cartId) {

        List<CartItem> cartItems =
                cartItemRepository.findByCartId(cartId);

        List<CartItemResponseDto> dtoList =
                new ArrayList<>();

        for (CartItem cartItem : cartItems) {

            dtoList.add(
                    convertToDto(cartItem));
        }

        return dtoList;
    }


    public Double calculateCartTotal(
            Long cartId) {

        List<CartItem> cartItems =
                cartItemRepository.findByCartId(cartId);

        double total = 0;

        for (CartItem item : cartItems) {

            total +=
                    item.getQuantity()
                            * item.getFoodItem()
                            .getPrice();
        }

        return total;
    }


    public CartItemResponseDto
    updateCartItem(
            Long id,
            CartItemRequestDto requestDto) {

        CartItem existingCartItem =
                cartItemRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart item not found with id: "
                                                + id));

        existingCartItem.setQuantity(
                requestDto.getQuantity());

        CartItem updatedCartItem =
                cartItemRepository.save(
                        existingCartItem);

        return convertToDto(updatedCartItem);
    }


    public CartItem convertToEntity(
            CartItemRequestDto dto) {

        CartItem cartItem =
                new CartItem();

        cartItem.setQuantity(
                dto.getQuantity());

        Cart cart =
                cartRepository.findById(
                                dto.getCartId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found with id: "
                                                + dto.getCartId()));

        FoodItem foodItem =
                foodItemRepository.findById(
                                dto.getFoodItemId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Food item not found with id: "
                                                + dto.getFoodItemId()));

        cartItem.setCart(cart);

        cartItem.setFoodItem(foodItem);

        return cartItem;
    }


    public CartItemResponseDto convertToDto(
            CartItem cartItem) {

        CartItemResponseDto dto =
                new CartItemResponseDto();

        dto.setId(
                cartItem.getId());

        dto.setQuantity(
                cartItem.getQuantity());

        dto.setFoodItemName(
                cartItem.getFoodItem().getName());

        dto.setFoodItemPrice(
                cartItem.getFoodItem().getPrice());

        dto.setFoodItemId(
                cartItem.getFoodItem().getId());

        dto.setCartId(
                cartItem.getCart().getId());

        return dto;
    }


    public void clearCart(Long cartId) {

        cartItemRepository
                .deleteByCartId(cartId);
    }
}