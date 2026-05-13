package com.fooddelivery.dto;

import jakarta.validation.constraints.NotNull;

public class CartRequestDto {

    @NotNull(message = "User ID is required")
    private Long userId;

    public CartRequestDto() {
    }

    public CartRequestDto(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}