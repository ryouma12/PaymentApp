package com.example.paymentapp.service;

import com.example.paymentapp.dto.OrderDetailsDto;
import com.example.paymentapp.dto.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto getOrderDetailsById(Long id);

    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);

    void updateOrderDetails(OrderDetailsRequest  orderDetailsRequest);

    List<OrderDetailsDto> getAll();

    void deleteOrderDetailsById(Long id);

}
