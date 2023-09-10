package com.example.paymentapp.controller;

import com.example.paymentapp.dto.OrderItemsDto;
import com.example.paymentapp.dto.request.OrderItemsRequest;
import com.example.paymentapp.model.OrderItems;
import com.example.paymentapp.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderitems")
public class OrderItemsController {
    final OrderItemsService orderItemsService;

    @GetMapping(value = "/orderitemsList")
    public List<OrderItemsDto> getOrderItemsInfo(){
        return orderItemsService.getAll();
    }

    @GetMapping(value = "/getOrderItemsById/{id}")
    public OrderItemsDto getOrderItemsById(@PathVariable(value = "id") Long id){
        return orderItemsService.getOrderItemsById(id);
    }

    @PostMapping(value = "/saveOrderItems")
    public void saveOrderItems(@RequestBody OrderItemsRequest orderItemsRequest){
        orderItemsService.saveOrderItems(orderItemsRequest);
    }

    @PostMapping(value = "/updateOrderItems")
    public void updateOrderItems(@RequestBody OrderItemsRequest orderItemsRequest){
        orderItemsService.updateOrderItems(orderItemsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteOrderItems(@PathVariable(value = "id") Long id){
        orderItemsService.deleteOrderItemsById(id);
    }


}
