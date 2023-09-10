package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.ShoppingSessionDto;
import com.example.paymentapp.dto.request.ShoppingSessionRequest;
import com.example.paymentapp.model.ShoppingSession;
import com.example.paymentapp.repository.ShoppingSessionRepository;
import com.example.paymentapp.service.ShoppingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ShoppingSessionServiceImpl implements ShoppingSessionService {

    final ShoppingSessionRepository shoppingSessionRepository;
    @Override
    public ShoppingSessionDto getShoppingSessionById(Long id) {
        ShoppingSession shoppingSession = shoppingSessionRepository.getShoppingSessionById(id);


        return ShoppingSessionDto.builder()
                .total(shoppingSession.getTotal())
                .modifiedAt(shoppingSession.getModifiedAt())
                .createdAt(shoppingSession.getCreatedAt())
                .build();
    }

    @Override
    public void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {

        shoppingSessionRepository.save(
                ShoppingSession.builder()
                        .total(shoppingSessionRequest.getTotal())
                        .modifiedAt(shoppingSessionRequest.getModifiedAt())
                        .createdAt(shoppingSessionRequest.getCreatedAt())
                        .build()
        );

    }

    @Override
    public void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {

        ShoppingSession shoppingSession = ShoppingSession.builder()
                .id(shoppingSessionRequest.getId())
                .total(shoppingSessionRequest.getTotal())
                .modifiedAt(shoppingSessionRequest.getModifiedAt())
                .createdAt(shoppingSessionRequest.getCreatedAt())
                .build();

        shoppingSessionRepository.save(shoppingSession);

    }

    @Override
    public List<ShoppingSessionDto> getAll() {

        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findAll();
        List<ShoppingSessionDto> shoppingSessionDtos = new ArrayList<>();

        for(ShoppingSession shoppingSession : shoppingSessions){
            ShoppingSessionDto shoppingSessionDto = ShoppingSessionDto.builder()
                    .total(shoppingSession.getTotal())
                    .createdAt(shoppingSession.getCreatedAt())
                    .modifiedAt(shoppingSession.getModifiedAt())
                    .build();

            shoppingSessionDtos.add(shoppingSessionDto);

        }

        return shoppingSessionDtos;
    }

    @Override
    public void deleteShoppingSessionById(Long id) {

        ShoppingSession shoppingSession = shoppingSessionRepository.getShoppingSessionById(id);

        shoppingSessionRepository.deleteById(id);
    }
}
