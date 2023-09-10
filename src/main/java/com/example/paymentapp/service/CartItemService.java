package com.example.paymentapp.service;

import com.example.paymentapp.dto.CartItemDto;
import com.example.paymentapp.dto.request.CartItemRequest;

import java.util.List;

public interface CartItemService {

    CartItemDto getCartItemDtoById(Long id);

    void saveCartItem(CartItemRequest cartItemRequest);
    void updateCartItem(CartItemRequest cartItemRequest);

    List<CartItemDto> getAll();
    void deleteCartItemById(Long id);

}
