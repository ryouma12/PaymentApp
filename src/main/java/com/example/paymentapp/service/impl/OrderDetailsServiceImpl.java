package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.OrderDetailsDto;
import com.example.paymentapp.dto.request.OrderDetailsRequest;
import com.example.paymentapp.model.OrderDetails;
import com.example.paymentapp.repository.OrderDetailsRepository;
import com.example.paymentapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    final OrderDetailsRepository orderDetailsRepository;
    @Override
    public OrderDetailsDto getOrderDetailsById(Long id) {

        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);


        return OrderDetailsDto.builder()
                .total(orderDetails.getTotal())
                .createdAt(orderDetails.getCreatedAt())
                .modifiedAt(orderDetails.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {

        orderDetailsRepository.save(
                OrderDetails.builder()
                        .total(orderDetailsRequest.getTotal())
                        .createdAt(orderDetailsRequest.getCreatedAt())
                        .modifiedAt(orderDetailsRequest.getModifiedAt())
                        .build()
        );

    }

    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .id(orderDetailsRequest.getId())
                .total(orderDetailsRequest.getTotal())
                .createdAt(orderDetailsRequest.getCreatedAt())
                .modifiedAt(orderDetailsRequest.getModifiedAt())
                .build();

        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public List<OrderDetailsDto> getAll() {

        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();

        for(OrderDetails orderDetails1 : orderDetails){

            OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                    .total(orderDetails1.getTotal())
                    .createdAt(orderDetails1.getCreatedAt())
                    .modifiedAt(orderDetails1.getModifiedAt())
                    .build();

        }

        return orderDetailsDtos;
    }

    @Override
    public void deleteOrderDetailsById(Long id) {

        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);

        orderDetailsRepository.deleteById(id);

    }
}
