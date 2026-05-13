package com.fooddelivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartItemRequestDto {

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    @NotNull(message = "Cart ID is required")
    private Long cartId;

    @NotNull(message = "Food item ID is required")
    private Long foodItemId;

    public CartItemRequestDto() {
    }

    public CartItemRequestDto(
            Integer quantity,
            Long cartId,
            Long foodItemId) {

        this.quantity = quantity;
        this.cartId = cartId;
        this.foodItemId = foodItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(
            Integer quantity) {

        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(
            Long foodItemId) {

        this.foodItemId = foodItemId;
    }
}