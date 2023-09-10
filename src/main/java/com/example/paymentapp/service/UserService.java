package com.example.paymentapp.service;

import com.example.paymentapp.dto.UserDto;
import com.example.paymentapp.dto.request.UserRequest;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);

    void saveUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);

    List<UserDto> getAll();

    void deleteUserById(Long id);

}
