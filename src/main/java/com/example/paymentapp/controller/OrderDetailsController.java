package com.example.paymentapp.controller;

import com.example.paymentapp.dto.OrderDetailsDto;
import com.example.paymentapp.dto.request.OrderDetailsRequest;
import com.example.paymentapp.repository.OrderDetailsRepository;
import com.example.paymentapp.service.OrderDetailsService;
import com.example.paymentapp.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderdetails")
public class OrderDetailsController {

final OrderDetailsService orderDetailsService;

    @GetMapping(value = "/orderdetailsList")
    public List<OrderDetailsDto> getOrderDetailsInfo(){
        return orderDetailsService.getAll();
    }

    @GetMapping(value = "/getOrderDetailsById/{id}")
    public OrderDetailsDto getOrderDetailsById(@PathVariable(value = "id") Long id){
        return orderDetailsService.getOrderDetailsById(id);
    }

    @PostMapping(value = "/saveOrderDetails")
    public void saveOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsService.saveOrderDetails(orderDetailsRequest);
    }

    @PostMapping(value = "/updateOrderDetails")
    public void updateOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsService.updateOrderDetails(orderDetailsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteOrderDetails(@PathVariable(value = "id") Long id){
        orderDetailsService.deleteOrderDetailsById(id);
    }



}
