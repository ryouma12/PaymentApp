package com.example.paymentapp.service;


import com.example.paymentapp.dto.PaymentDetailsDto;
import com.example.paymentapp.dto.request.PaymentDetailsRequest;


import java.util.List;

public interface PaymentDetailsService {
    PaymentDetailsDto getPaymentById(Long id);

    void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);

    void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);

    List<PaymentDetailsDto> getAll();

    void deletePaymentDetailsById(Long id);


}
