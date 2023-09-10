package com.example.paymentapp.repository;

import com.example.paymentapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

}
