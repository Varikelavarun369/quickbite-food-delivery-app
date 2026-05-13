package com.fooddelivery.controller;

import com.fooddelivery.dto.OrderItemResponseDto;
import com.fooddelivery.service.OrderItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @GetMapping
    public List<OrderItemResponseDto>
    getAllOrderItems() {

        return orderItemService
                .getAllOrderItems();
    }


    @GetMapping("/order/{orderId}")
    public List<OrderItemResponseDto>
    getOrderItemsByOrderId(
            @PathVariable Long orderId) {

        return orderItemService
                .getOrderItemsByOrderId(orderId);
    }
}