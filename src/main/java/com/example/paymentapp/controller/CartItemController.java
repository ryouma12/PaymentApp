package com.example.paymentapp.controller;

import com.example.paymentapp.dto.CartItemDto;
import com.example.paymentapp.dto.request.CartItemRequest;
import com.example.paymentapp.service.CartItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart_item")
public class CartItemController {

    final CartItemService cartItemService;

    @GetMapping(value = "/cart_itemList" )
    public List<CartItemDto> getCartItemInfo(){
        return cartItemService.getAll();
    }

    @GetMapping(value = "/getCartItemByID/{id}")
    public CartItemDto getCartItemByID(@PathVariable(value = "id") Long id){
        return cartItemService.getCartItemDtoById(id);
    }

    @PostMapping(value = "/saveCartItem")
    public void saveCartItem(@RequestBody CartItemRequest cartItemRequest){
        cartItemService.saveCartItem(cartItemRequest);
    }

    @PostMapping(value = "/updateCartItem")
    public void updateCartItem(@RequestBody CartItemRequest cartItemRequest){
        cartItemService.updateCartItem(cartItemRequest);

    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        cartItemService.deleteCartItemById(id);
    }

}
