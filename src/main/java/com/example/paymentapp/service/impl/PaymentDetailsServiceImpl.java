package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.PaymentDetailsDto;
import com.example.paymentapp.dto.request.PaymentDetailsRequest;
import com.example.paymentapp.model.PaymentDetails;
import com.example.paymentapp.repository.PaymentDetailsRepository;
import com.example.paymentapp.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    final PaymentDetailsRepository paymentDetailsRepository;




    @Override
    public PaymentDetailsDto getPaymentById(Long id) {
        PaymentDetails paymentDetails = paymentDetailsRepository.getPaymentDetailsById(id);
        return PaymentDetailsDto.builder()
                .amount(paymentDetails.getAmount())
                .provider(paymentDetails.getProvider())
                .status(paymentDetails.getStatus())
                .createdAt(paymentDetails.getCreatedAt())
                .modifiedAt(paymentDetails.getModifiedAt())
                .build();
    }

    @Override
    public void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {

        paymentDetailsRepository.save(
                PaymentDetails.builder()
                        .amount(paymentDetailsRequest.getAmount())
                        .provider(paymentDetailsRequest.getProvider())
                        .status(paymentDetailsRequest.getStatus())
                        .modifiedAt(paymentDetailsRequest.getModifiedAt())
                        .createdAt(paymentDetailsRequest.getCreatedAt())
                        .build()
        );

    }

    @Override
    public void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .id(paymentDetailsRequest.getId())
                .amount(paymentDetailsRequest.getAmount())
                .provider(paymentDetailsRequest.getProvider())
                .status(paymentDetailsRequest.getStatus())
                .modifiedAt(paymentDetailsRequest.getModifiedAt())
                .createdAt(paymentDetailsRequest.getCreatedAt())
                .build();

        paymentDetailsRepository.save(paymentDetails);

    }

    @Override
    public List<PaymentDetailsDto> getAll() {

        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAll();
        List<PaymentDetailsDto> paymentDetailsDtos = new ArrayList<>();
        for(PaymentDetails paymentDetails1 : paymentDetails){

            PaymentDetailsDto paymentDetailsDto = PaymentDetailsDto.builder()
                    .amount(paymentDetails1.getAmount())
                    .provider(paymentDetails1.getProvider())
                    .status(paymentDetails1.getStatus())
                    .modifiedAt(paymentDetails1.getModifiedAt())
                    .createdAt(paymentDetails1.getCreatedAt())
                    .build();

        }


        return paymentDetailsDtos;
    }

    @Override
    public void deletePaymentDetailsById(Long id) {

        PaymentDetails paymentDetails = paymentDetailsRepository.getPaymentDetailsById(id);

        paymentDetailsRepository.deleteById(id);

    }
}
