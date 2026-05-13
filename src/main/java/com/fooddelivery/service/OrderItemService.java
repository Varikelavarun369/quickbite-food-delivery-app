package com.fooddelivery.service;

import com.fooddelivery.dto.OrderItemRequestDto;
import com.fooddelivery.dto.OrderItemResponseDto;
import com.fooddelivery.entity.CartItem;
import com.fooddelivery.entity.FoodItem;
import com.fooddelivery.entity.OrderEntity;
import com.fooddelivery.entity.OrderItem;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.FoodItemRepository;
import com.fooddelivery.repository.OrderItemRepository;
import com.fooddelivery.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;


    public OrderItemResponseDto saveOrderItem(
            OrderItemRequestDto requestDto) {

        OrderItem orderItem =
                convertToEntity(requestDto);

        OrderItem savedOrderItem =
                orderItemRepository.save(orderItem);

        return convertToDto(savedOrderItem);
    }


    public List<OrderItemResponseDto>
    getAllOrderItems() {

        List<OrderItem> orderItems =
                orderItemRepository.findAll();

        List<OrderItemResponseDto> dtoList =
                new ArrayList<>();

        for (OrderItem orderItem : orderItems) {

            dtoList.add(
                    convertToDto(orderItem));
        }

        return dtoList;
    }


    public List<OrderItemResponseDto>
    getOrderItemsByOrderId(Long orderId) {

        List<OrderItem> orderItems =
                orderItemRepository
                        .findByOrderId(orderId);

        List<OrderItemResponseDto> dtoList =
                new ArrayList<>();

        for (OrderItem orderItem : orderItems) {

            dtoList.add(
                    convertToDto(orderItem));
        }

        return dtoList;
    }


    public void createOrderItemsFromCart(
            OrderEntity order,
            List<CartItem> cartItems) {

        for (CartItem cartItem : cartItems) {

            OrderItem orderItem =
                    new OrderItem();

            orderItem.setOrder(order);

            orderItem.setFoodItem(
                    cartItem.getFoodItem());

            orderItem.setQuantity(
                    cartItem.getQuantity());

            orderItem.setPrice(
                    cartItem.getFoodItem()
                            .getPrice());

            orderItemRepository
                    .save(orderItem);
        }
    }


    public OrderItem convertToEntity(
            OrderItemRequestDto dto) {

        OrderItem orderItem =
                new OrderItem();

        orderItem.setQuantity(
                dto.getQuantity());

        orderItem.setPrice(
                dto.getPrice());

        OrderEntity order =
                orderRepository.findById(
                                dto.getOrderId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Order not found with id: "
                                                + dto.getOrderId()));

        FoodItem foodItem =
                foodItemRepository.findById(
                                dto.getFoodItemId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Food item not found with id: "
                                                + dto.getFoodItemId()));

        orderItem.setOrder(order);

        orderItem.setFoodItem(foodItem);

        return orderItem;
    }


    public OrderItemResponseDto convertToDto(
            OrderItem orderItem) {

        OrderItemResponseDto dto =
                new OrderItemResponseDto();

        dto.setId(orderItem.getId());

        dto.setQuantity(
                orderItem.getQuantity());

        dto.setPrice(
                orderItem.getPrice());

        dto.setFoodItemName(
                orderItem.getFoodItem().getName());

        dto.setOrderId(
                orderItem.getOrder().getId());

        return dto;
    }
}