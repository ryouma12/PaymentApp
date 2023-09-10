package com.example.paymentapp.repository;

import com.example.paymentapp.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Discount getDiscountById(Long id);

}
