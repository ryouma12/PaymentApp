package com.example.paymentapp.service;

import com.example.paymentapp.dto.OrderItemsDto;
import com.example.paymentapp.dto.request.OrderItemsRequest;

import java.util.List;

public interface OrderItemsService {


    OrderItemsDto getOrderItemsById(Long id);

    void saveOrderItems(OrderItemsRequest orderItemsRequest);

    void updateOrderItems(OrderItemsRequest orderItemsRequest);

    List<OrderItemsDto> getAll();

    void deleteOrderItemsById(Long id);
}
