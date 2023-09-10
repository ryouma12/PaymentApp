package com.example.paymentapp.repository;

import com.example.paymentapp.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

    OrderItems getOrderItemsById(Long id);


}
