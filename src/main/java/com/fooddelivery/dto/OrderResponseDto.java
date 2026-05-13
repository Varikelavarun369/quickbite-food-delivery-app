package com.fooddelivery.dto;

public class OrderResponseDto {

    private Long id;

    private Double totalAmount;

    private String status;

    private String userName;

    public OrderResponseDto() {
    }

    public OrderResponseDto(
            Long id,
            Double totalAmount,
            String status,
            String userName) {

        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            Double totalAmount) {

        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(
            String userName) {

        this.userName = userName;
    }
}
