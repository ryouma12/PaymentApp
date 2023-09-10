package com.example.paymentapp.service;

import com.example.paymentapp.dto.DiscountDto;
import com.example.paymentapp.dto.request.DiscountRequest;

import java.util.List;

public interface DiscountService {

    DiscountDto getDiscountById(Long id);

    void saveDiscount(DiscountRequest discountRequest);
    void updateDiscount(DiscountRequest discountRequest);

    List<DiscountDto> getAll();

    void deleteDiscountById(Long id);


}
