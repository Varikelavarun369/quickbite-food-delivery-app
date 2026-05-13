package com.fooddelivery.dto;

public class CartResponseDto {

    private Long id;

    private String userName;

    public CartResponseDto() {
    }

    public CartResponseDto(
            Long id,
            String userName) {

        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(
            String userName) {

        this.userName = userName;
    }
}