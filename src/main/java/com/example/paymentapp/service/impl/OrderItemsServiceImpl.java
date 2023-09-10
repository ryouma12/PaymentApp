package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.OrderItemsDto;
import com.example.paymentapp.dto.request.OrderItemsRequest;
import com.example.paymentapp.model.OrderItems;
import com.example.paymentapp.repository.OrderItemsRepository;
import com.example.paymentapp.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {

    final OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItemsDto getOrderItemsById(Long id) {

        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        return OrderItemsDto.builder()
                .createdAt(orderItems.getCreatedAt())
                .modifiedAt(orderItems.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderItems(OrderItemsRequest orderItemsRequest) {

        orderItemsRepository.save(
                OrderItems.builder()
                        .modifiedAt(orderItemsRequest.getModifiedAt())
                        .createdAt(orderItemsRequest.getCreatedAt())
                        .build()
        );

    }

    @Override
    public void updateOrderItems(OrderItemsRequest orderItemsRequest) {

        OrderItems orderItems = OrderItems.builder()
                .id(orderItemsRequest.getId())
                .modifiedAt(orderItemsRequest.getModifiedAt())
                .createdAt(orderItemsRequest.getCreatedAt())
                .build();

        orderItemsRepository.save(orderItems);

    }

    @Override
    public List<OrderItemsDto> getAll() {
        List<OrderItems> orderItems = orderItemsRepository.findAll();

        List<OrderItemsDto> orderItemsDtos = new ArrayList<>();

        for(OrderItems orderItems1 : orderItems){

            OrderItemsDto orderItemsDto = OrderItemsDto.builder()
                    .modifiedAt(orderItems1.getModifiedAt())
                    .createdAt(orderItems1.getCreatedAt())
                    .build();

        }

        return orderItemsDtos;
    }

    @Override
    public void deleteOrderItemsById(Long id) {

        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        orderItemsRepository.deleteById(id);

    }
}
