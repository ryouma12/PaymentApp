package com.example.paymentapp.controller;

import com.example.paymentapp.dto.ShoppingSessionDto;
import com.example.paymentapp.dto.request.ShoppingSessionRequest;
import com.example.paymentapp.model.ShoppingSession;
import com.example.paymentapp.service.ShoppingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/shoppingsession")
public class ShoppingSessionController {

    final ShoppingSessionService shoppingSessionService;

    @GetMapping (value = "/shoppingsessionList")
    public List<ShoppingSessionDto> getShoppingSessionInfo(){
        return shoppingSessionService.getAll();
    }

    @GetMapping(value = "/getShoppingSessionById/{id}")
    public ShoppingSessionDto getShoppingSessionById(@PathVariable(value = "id") Long id){
        return shoppingSessionService.getShoppingSessionById(id);
    }

    @PostMapping(value = "/saveShoppingSession")
    public void saveShoppingSession(@RequestBody ShoppingSessionRequest shoppingSessionRequest){
        shoppingSessionService.saveShoppingSession(shoppingSessionRequest);
    }

    @PostMapping(value = "/updateShoppingSession")
    public void updateShoppingSession(@RequestBody ShoppingSessionRequest shoppingSessionRequest){
        shoppingSessionService.updateShoppingSession(shoppingSessionRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteShoppingSessionById(@PathVariable(value = "id") Long id){
        shoppingSessionService.deleteShoppingSessionById(id);
    }

}
