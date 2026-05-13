package com.fooddelivery.controller;

import com.fooddelivery.dto.OrderRequestDto;
import com.fooddelivery.dto.OrderResponseDto;
import com.fooddelivery.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public OrderResponseDto saveOrder(

            @Valid
            @RequestBody OrderRequestDto requestDto) {

        return orderService.saveOrder(requestDto);
    }


    @GetMapping
    public List<OrderResponseDto>
    getAllOrders() {

        return orderService.getAllOrders();
    }


    @GetMapping("/{id}")
    public OrderResponseDto
    getOrderById(
            @PathVariable Long id) {

        return orderService.getOrderById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteOrder(
            @PathVariable Long id) {

        return orderService.deleteOrder(id);
    }


    @PostMapping("/place/{cartId}")
    public OrderResponseDto placeOrder(
            @PathVariable Long cartId) {

        return orderService.placeOrder(cartId);
    }


    @GetMapping("/user/{userId}")
    public List<OrderResponseDto>
    getOrdersByUserId(
            @PathVariable Long userId) {

        return orderService
                .getOrdersByUserId(userId);
    }


    @PutMapping("/{id}/status")
    public OrderResponseDto
    updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return orderService
                .updateOrderStatus(id, status);
    }
}