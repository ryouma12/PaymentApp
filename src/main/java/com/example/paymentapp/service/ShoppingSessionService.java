package com.example.paymentapp.service;

import com.example.paymentapp.dto.ShoppingSessionDto;
import com.example.paymentapp.dto.request.ShoppingSessionRequest;

import java.util.List;

public interface ShoppingSessionService {

    ShoppingSessionDto getShoppingSessionById(Long id);

    void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest);
    void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest);

    List<ShoppingSessionDto> getAll();

    void deleteShoppingSessionById(Long id);
}
