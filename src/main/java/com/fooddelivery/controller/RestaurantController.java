package com.fooddelivery.controller;

import com.fooddelivery.dto.RestaurantRequestDto;
import com.fooddelivery.dto.RestaurantResponseDto;
import com.fooddelivery.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public RestaurantResponseDto saveRestaurant(

            @Valid
            @RequestBody RestaurantRequestDto requestDto) {

        return restaurantService.saveRestaurant(
                requestDto);
    }


    @GetMapping
    public List<RestaurantResponseDto>
    getAllRestaurants() {

        return restaurantService.getAllRestaurants();
    }


    @GetMapping("/{id}")
    public RestaurantResponseDto
    getRestaurantById(
            @PathVariable Long id) {

        return restaurantService.getRestaurantById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteRestaurant(
            @PathVariable Long id) {

        return restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/cuisine/{cuisineType}")

    public List<RestaurantResponseDto>
    searchByCuisineType(

            @PathVariable
            String cuisineType) {

        return restaurantService
                .searchByCuisineType(
                        cuisineType);
    }
}