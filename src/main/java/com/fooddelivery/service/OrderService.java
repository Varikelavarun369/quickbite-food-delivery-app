package com.fooddelivery.service;

import com.fooddelivery.dto.OrderRequestDto;
import com.fooddelivery.dto.OrderResponseDto;
import com.fooddelivery.entity.Cart;
import com.fooddelivery.entity.CartItem;
import com.fooddelivery.entity.OrderEntity;
import com.fooddelivery.entity.User;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.CartItemRepository;
import com.fooddelivery.repository.CartRepository;
import com.fooddelivery.repository.OrderRepository;
import com.fooddelivery.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private OrderItemService orderItemService;


    public OrderResponseDto saveOrder(
            OrderRequestDto requestDto) {

        OrderEntity order =
                convertToEntity(requestDto);

        OrderEntity savedOrder =
                orderRepository.save(order);

        return convertToDto(savedOrder);
    }


    public List<OrderResponseDto>
    getAllOrders() {

        List<OrderEntity> orders =
                orderRepository.findAll();

        List<OrderResponseDto> dtoList =
                new ArrayList<>();

        for (OrderEntity order : orders) {

            dtoList.add(
                    convertToDto(order));
        }

        return dtoList;
    }


    public OrderResponseDto
    getOrderById(Long id) {

        OrderEntity order =
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Order not found with id: "
                                                + id));

        return convertToDto(order);
    }


    public String deleteOrder(Long id) {

        OrderEntity order =
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Order not found with id: "
                                                + id));

        orderRepository.delete(order);

        return "Order deleted successfully";
    }


    public OrderResponseDto placeOrder(
            Long cartId) {

        Cart cart =
                cartRepository.findById(cartId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found with id: "
                                                + cartId));

        List<CartItem> cartItems =
                cartItemRepository
                        .findByCartId(cartId);

        if (cartItems.isEmpty()) {

            throw new RuntimeException(
                    "Cart is empty");
        }

        Double totalAmount =
                cartItemService
                        .calculateCartTotal(cartId);

        User user =
                cart.getUser();

        OrderEntity order =
                new OrderEntity();

        order.setUser(user);

        order.setTotalAmount(
                totalAmount);

        order.setStatus(
                "PLACED");

        OrderEntity savedOrder =
                orderRepository.save(order);


        orderItemService
                .createOrderItemsFromCart(
                        savedOrder,
                        cartItems);


        cartItemService
                .clearCart(cartId);

        return convertToDto(savedOrder);
    }


    public List<OrderResponseDto>
    getOrdersByUserId(Long userId) {

        List<OrderEntity> orders =
                orderRepository
                        .findByUserId(userId);

        List<OrderResponseDto> dtoList =
                new ArrayList<>();

        for (OrderEntity order : orders) {

            dtoList.add(
                    convertToDto(order));
        }

        return dtoList;
    }


    public OrderResponseDto
    updateOrderStatus(
            Long id,
            String status) {

        OrderEntity order =
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Order not found with id: "
                                                + id));

        order.setStatus(status);

        OrderEntity updatedOrder =
                orderRepository.save(order);

        return convertToDto(updatedOrder);
    }


    public OrderEntity convertToEntity(
            OrderRequestDto dto) {

        OrderEntity order =
                new OrderEntity();

        order.setTotalAmount(
                dto.getTotalAmount());

        order.setStatus(
                dto.getStatus());

        User user =
                userRepository.findById(
                                dto.getUserId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with id: "
                                                + dto.getUserId()));

        order.setUser(user);

        return order;
    }


    public OrderResponseDto convertToDto(
            OrderEntity order) {

        OrderResponseDto dto =
                new OrderResponseDto();

        dto.setId(order.getId());

        dto.setTotalAmount(
                order.getTotalAmount());

        dto.setStatus(
                order.getStatus());

        dto.setUserName(
                order.getUser().getName());

        return dto;
    }
}