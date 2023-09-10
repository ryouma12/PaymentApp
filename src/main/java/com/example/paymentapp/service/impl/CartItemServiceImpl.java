package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.CartItemDto;
import com.example.paymentapp.dto.DiscountDto;
import com.example.paymentapp.dto.request.CartItemRequest;
import com.example.paymentapp.model.CartItem;
import com.example.paymentapp.repository.CartItemRepository;
import com.example.paymentapp.service.CartItemService;
import lombok.CustomLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    final CartItemRepository cartItemRepository;


    @Override
    public CartItemDto getCartItemDtoById(Long id) {

        CartItem cartItem = cartItemRepository.getCartItemById(id);
        return CartItemDto.builder()
                .quantity(cartItem.getQuantity())
                .createdAt(cartItem.getCreatedAt())
                .modifiedAt(cartItem.getModifiedAt())
                .build();
    }

    @Override
    public void saveCartItem(CartItemRequest cartItemRequest) {

            cartItemRepository.save(
                    CartItem.builder()
                            .quantity(cartItemRequest.getQuantity())
                            .createdAt(cartItemRequest.getCreatedAt())
                            .modifiedAt(cartItemRequest.getModifiedAt())
                            .build()
            );

    }

    @Override
    public void updateCartItem(CartItemRequest cartItemRequest) {

        CartItem cartItem = CartItem.builder()
                .id(cartItemRequest.getId())
                .modifiedAt(cartItemRequest.getModifiedAt())
                .createdAt(cartItemRequest.getCreatedAt())
                .quantity(cartItemRequest.getQuantity())
                .build();
cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItemDto> getAll() {

        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for(CartItem cartItem : cartItems){
            CartItemDto cartItemDto = CartItemDto.builder()
                    .modifiedAt(cartItem.getModifiedAt())
                    .createdAt(cartItem.getCreatedAt())
                    .quantity(cartItem.getQuantity())
                    .build();

        }
        return cartItemDtos;
    }

    @Override
    public void deleteCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);

        cartItemRepository.deleteById(id);


    }
}
