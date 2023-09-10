package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.DiscountDto;
import com.example.paymentapp.dto.request.DiscountRequest;
import com.example.paymentapp.model.Discount;
import com.example.paymentapp.repository.DiscountRepository;
import com.example.paymentapp.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    final DiscountRepository discountRepository;
    @Override
    public DiscountDto getDiscountById(Long id) {

        Discount discount = discountRepository.getDiscountById(id);
        return DiscountDto.builder()
                .name(discount.getName())
                .desc(discount.getDesc())
                .discountPercent(discount.getDiscountPercent())
                .createdAt(discount.getCreatedAt())
                .modifiedAt(discount.getModifiedAt())
                .build();
    }

    @Override
    public void saveDiscount(DiscountRequest discountRequest) {

        discountRepository.save(
                Discount.builder()
                        .name(discountRequest.getName())
                        .desc(discountRequest.getDesc())
                        .discountPercent(discountRequest.getDiscountPercent())
                        .createdAt(discountRequest.getCreatedAt())
                        .modifiedAt(discountRequest.getModifiedAt())
                        .build()
        );

    }

    @Override
    public void updateDiscount(DiscountRequest discountRequest) {
        Discount discount = Discount.builder()
                .id(discountRequest.getId())
                .name(discountRequest.getName())
                .desc(discountRequest.getDesc())
                .discountPercent(discountRequest.getDiscountPercent())
                .createdAt(discountRequest.getCreatedAt())
                .modifiedAt(discountRequest.getModifiedAt())
                .build();

        discountRepository.save(discount);


    }

    @Override
    public List<DiscountDto> getAll() {

        List<Discount> discounts = discountRepository.findAll();
        List<DiscountDto> discountDtos = new ArrayList<>();

        for(Discount discount : discounts){

            DiscountDto discountDto = DiscountDto.builder()
                    .name(discount.getName())
                    .desc(discount.getDesc())
                    .discountPercent(discount.getDiscountPercent())
                    .createdAt(discount.getCreatedAt())
                    .modifiedAt(discount.getModifiedAt())

                    .build();

        }

        return discountDtos;
    }

    @Override
    public void deleteDiscountById(Long id) {

        Discount discount = discountRepository.getDiscountById(id);

        discountRepository.deleteById(id);


    }
}
