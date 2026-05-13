package com.fooddelivery.controller;

import com.fooddelivery.dto.FoodItemRequestDto;

import com.fooddelivery.dto.FoodItemResponseDto;

import com.fooddelivery.service.FoodItemService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService
            foodItemService;

    @PostMapping
    public FoodItemResponseDto
    saveFoodItem(

            @Valid

            @RequestBody
            FoodItemRequestDto requestDto) {

        return foodItemService
                .saveFoodItem(
                        requestDto);
    }

    @GetMapping
    public List<FoodItemResponseDto>
    getAllFoodItems() {

        return foodItemService
                .getAllFoodItems();
    }

    @GetMapping("/{id}")
    public FoodItemResponseDto
    getFoodItemById(

            @PathVariable
            Long id) {

        return foodItemService
                .getFoodItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodItem(

            @PathVariable
            Long id) {

        return foodItemService
                .deleteFoodItem(id);
    }

    @GetMapping("/search/{name}")
    public List<FoodItemResponseDto>
    searchFoodItems(

            @PathVariable
            String name) {

        return foodItemService
                .searchFoodItems(name);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodItemResponseDto>
    getFoodItemsByRestaurant(

            @PathVariable
            Long restaurantId) {

        return foodItemService
                .getFoodItemsByRestaurant(
                        restaurantId);
    }
}