package com.fooddelivery.repository;

import com.fooddelivery.entity.FoodItem;
import com.fooddelivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository
        extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByNameContaining(
            String name);
    List<FoodItem>
    findByRestaurant(
            Restaurant restaurant);

}