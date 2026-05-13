package com.fooddelivery.dto;

public class CartItemResponseDto {

    private Long id;

    private Integer quantity;

    private String foodItemName;

    private Double foodItemPrice;

    private Long cartId;

    private Long foodItemId;

    public CartItemResponseDto() {
    }

    public CartItemResponseDto(

            Long id,

            Integer quantity,

            String foodItemName,

            Double foodItemPrice,

            Long cartId,

            Long foodItemId) {

        this.id = id;

        this.quantity = quantity;

        this.foodItemName = foodItemName;

        this.foodItemPrice = foodItemPrice;

        this.cartId = cartId;

        this.foodItemId = foodItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(
            Integer quantity) {

        this.quantity = quantity;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(
            String foodItemName) {

        this.foodItemName = foodItemName;
    }

    public Double getFoodItemPrice() {
        return foodItemPrice;
    }

    public void setFoodItemPrice(
            Double foodItemPrice) {

        this.foodItemPrice = foodItemPrice;
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