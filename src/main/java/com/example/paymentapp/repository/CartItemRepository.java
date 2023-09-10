package com.example.paymentapp.repository;

import com.example.paymentapp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem getCartItemById(Long id);



}
