package com.fooddelivery.dto;

public class FoodItemResponseDto {

    private Long id;

    private String name;

    private Double price;

    private String description;

    private Boolean available;

    private String restaurantName;

    public FoodItemResponseDto() {
    }

    public FoodItemResponseDto(
            Long id,
            String name,
            Double price,
            String description,
            Boolean available,
            String restaurantName) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
        this.restaurantName = restaurantName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(
            String restaurantName) {

        this.restaurantName = restaurantName;
    }
}