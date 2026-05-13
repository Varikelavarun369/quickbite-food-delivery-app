package com.fooddelivery.service;

import com.fooddelivery.dto.FoodItemRequestDto;

import com.fooddelivery.dto.FoodItemResponseDto;

import com.fooddelivery.entity.FoodItem;

import com.fooddelivery.entity.Restaurant;

import com.fooddelivery.exception.ResourceNotFoundException;

import com.fooddelivery.repository.FoodItemRepository;

import com.fooddelivery.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository
            foodItemRepository;

    @Autowired
    private RestaurantRepository
            restaurantRepository;

    public FoodItemResponseDto
    saveFoodItem(
            FoodItemRequestDto requestDto) {

        FoodItem foodItem =
                convertToEntity(requestDto);

        FoodItem savedFoodItem =
                foodItemRepository.save(foodItem);

        return convertToDto(savedFoodItem);
    }

    public List<FoodItemResponseDto>
    getAllFoodItems() {

        List<FoodItem> foodItems =
                foodItemRepository.findAll();

        List<FoodItemResponseDto> dtoList =
                new ArrayList<>();

        for (FoodItem foodItem : foodItems) {

            dtoList.add(
                    convertToDto(foodItem));
        }

        return dtoList;
    }

    public FoodItemResponseDto
    getFoodItemById(Long id) {

        FoodItem foodItem =
                foodItemRepository.findById(id)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(

                                        "Food item not found with id: "
                                                + id));

        return convertToDto(foodItem);
    }

    public String deleteFoodItem(
            Long id) {

        FoodItem foodItem =
                foodItemRepository.findById(id)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(

                                        "Food item not found with id: "
                                                + id));

        foodItemRepository.delete(foodItem);

        return "Food item deleted successfully";
    }

    public FoodItem convertToEntity(
            FoodItemRequestDto dto) {

        FoodItem foodItem =
                new FoodItem();

        foodItem.setName(dto.getName());

        foodItem.setPrice(dto.getPrice());

        foodItem.setDescription(
                dto.getDescription());

        foodItem.setAvailable(
                dto.getAvailable());

        Restaurant restaurant =

                restaurantRepository.findById(
                                dto.getRestaurantId())

                        .orElseThrow(() ->

                                new ResourceNotFoundException(

                                        "Restaurant not found with id: "
                                                + dto.getRestaurantId()));

        foodItem.setRestaurant(
                restaurant);

        return foodItem;
    }

    public FoodItemResponseDto
    convertToDto(
            FoodItem foodItem) {

        FoodItemResponseDto dto =
                new FoodItemResponseDto();

        dto.setId(foodItem.getId());

        dto.setName(foodItem.getName());

        dto.setPrice(foodItem.getPrice());

        dto.setDescription(
                foodItem.getDescription());

        dto.setAvailable(
                foodItem.getAvailable());

        dto.setRestaurantName(
                foodItem.getRestaurant().getName());

        return dto;
    }

    public List<FoodItemResponseDto>
    searchFoodItems(
            String name) {

        List<FoodItem> foodItems =

                foodItemRepository
                        .findByNameContaining(
                                name);

        List<FoodItemResponseDto> dtoList =
                new ArrayList<>();

        for (FoodItem foodItem : foodItems) {

            dtoList.add(
                    convertToDto(foodItem));
        }

        return dtoList;
    }

    public List<FoodItemResponseDto>
    getFoodItemsByRestaurant(
            Long restaurantId) {

        Restaurant restaurant =

                restaurantRepository.findById(
                                restaurantId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(

                                        "Restaurant not found with id: "
                                                + restaurantId));

        List<FoodItem> foodItems =

                foodItemRepository
                        .findByRestaurant(
                                restaurant);

        List<FoodItemResponseDto> dtoList =
                new ArrayList<>();

        for (FoodItem foodItem : foodItems) {

            dtoList.add(
                    convertToDto(foodItem));
        }

        return dtoList;
    }
}