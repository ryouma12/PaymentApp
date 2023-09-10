package com.example.paymentapp.repository;

import com.example.paymentapp.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    OrderDetails getOrderDetailsById(Long id);

}
