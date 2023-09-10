package com.example.paymentapp.controller;

import com.example.paymentapp.dto.PaymentDetailsDto;
import com.example.paymentapp.dto.request.PaymentDetailsRequest;
import com.example.paymentapp.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/paymentdetails")
public class PaymentDetailsController {

    final PaymentDetailsService paymentDetailsService;

    @GetMapping(value = "/paymentdetailsList")
    public List<PaymentDetailsDto> getPaymentDetailsInfo(){
        return paymentDetailsService.getAll();
    }

    @GetMapping(value = "/getPaymentdetailsById/{id}")
    public PaymentDetailsDto getPaymentDetailsById(@PathVariable(value = "id") Long id){
        return paymentDetailsService.getPaymentById(id);
    }

    @PostMapping(value = "/savePaymentDetails")
    public void savePaymentsDetails(@RequestBody PaymentDetailsRequest paymentDetailsRequest){
        paymentDetailsService.savePaymentDetails(paymentDetailsRequest);
    }

    @PostMapping(value = "/updatePaymentDetails")
    public void updatePaymentDetails(@RequestBody PaymentDetailsRequest paymentDetailsRequest){
        paymentDetailsService.updatePaymentDetails(paymentDetailsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deletePaymentDetails(@PathVariable(value = "id") Long id){
        paymentDetailsService.deletePaymentDetailsById(id);
    }



}
