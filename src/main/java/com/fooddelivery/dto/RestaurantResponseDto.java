package com.fooddelivery.dto;

public class RestaurantResponseDto {

    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String cuisineType;

    public RestaurantResponseDto() {
    }

    public RestaurantResponseDto(
            Long id,
            String name,
            String address,
            String phoneNumber,
            String cuisineType) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cuisineType = cuisineType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}