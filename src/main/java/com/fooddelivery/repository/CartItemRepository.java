package com.fooddelivery.repository;

import com.fooddelivery.entity.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartId(Long cartId);
    @Transactional
    @Modifying
    void deleteByCartId(Long cartId);
}