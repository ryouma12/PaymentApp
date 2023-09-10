package com.example.paymentapp.repository;

import com.example.paymentapp.model.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Long> {

    ShoppingSession getShoppingSessionById(Long id);

}
