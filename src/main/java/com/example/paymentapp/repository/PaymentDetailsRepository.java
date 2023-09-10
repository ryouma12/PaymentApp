package com.example.paymentapp.repository;

import com.example.paymentapp.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

    PaymentDetails getPaymentDetailsById(Long id);

}
