package com.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FoodItemRequestDto {

    @NotBlank(message = "Food item name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Availability status is required")
    private Boolean available;

    @NotNull(message = "Restaurant ID is required")
    private Long restaurantId;

    public FoodItemRequestDto() {
    }

    public FoodItemRequestDto(
            String name,
            Double price,
            String description,
            Boolean available,
            Long restaurantId) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}