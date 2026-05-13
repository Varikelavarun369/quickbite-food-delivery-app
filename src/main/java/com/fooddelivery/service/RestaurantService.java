package com.fooddelivery.service;

import com.fooddelivery.dto.RestaurantRequestDto;
import com.fooddelivery.dto.RestaurantResponseDto;
import com.fooddelivery.entity.Restaurant;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public RestaurantResponseDto saveRestaurant(
            RestaurantRequestDto requestDto) {

        Restaurant restaurant =
                convertToEntity(requestDto);

        Restaurant savedRestaurant =
                restaurantRepository.save(restaurant);

        return convertToDto(savedRestaurant);
    }


    public List<RestaurantResponseDto>
    getAllRestaurants() {

        List<Restaurant> restaurants =
                restaurantRepository.findAll();

        List<RestaurantResponseDto> dtoList =
                new ArrayList<>();

        for (Restaurant restaurant : restaurants) {

            dtoList.add(convertToDto(restaurant));
        }

        return dtoList;
    }


    public RestaurantResponseDto
    getRestaurantById(Long id) {

        Restaurant restaurant =
                restaurantRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Restaurant not found with id: " + id));

        return convertToDto(restaurant);
    }


    public String deleteRestaurant(Long id) {

        Restaurant restaurant =
                restaurantRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Restaurant not found with id: " + id));

        restaurantRepository.delete(restaurant);

        return "Restaurant deleted successfully";
    }


    public Restaurant convertToEntity(
            RestaurantRequestDto dto) {

        Restaurant restaurant =
                new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhoneNumber(
                dto.getPhoneNumber());
        restaurant.setCuisineType(
                dto.getCuisineType());

        return restaurant;
    }


    public RestaurantResponseDto convertToDto(
            Restaurant restaurant) {

        RestaurantResponseDto dto =
                new RestaurantResponseDto();

        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setPhoneNumber(
                restaurant.getPhoneNumber());
        dto.setCuisineType(
                restaurant.getCuisineType());

        return dto;
    }
    public List<RestaurantResponseDto>
    searchByCuisineType(
            String cuisineType) {

        List<Restaurant> restaurants =

                restaurantRepository
                        .findByCuisineType(
                                cuisineType);

        List<RestaurantResponseDto> dtoList =
                new ArrayList<>();

        for (Restaurant restaurant : restaurants) {

            dtoList.add(
                    convertToDto(restaurant));
        }

        return dtoList;
    }
}