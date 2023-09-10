package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.UserDto;
import com.example.paymentapp.dto.request.UserRequest;
import com.example.paymentapp.model.User;
import com.example.paymentapp.repository.UserRepository;
import com.example.paymentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository.getUserById(id);

            return UserDto.builder()
                    .userName(user.getUserName())
                    .passWord(user.getPassWord())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .address(user.getAddress())
                    .telephone(user.getTelephone())
                    .createdAt(user.getCreatedAt())
                    .modifiedAt(user.getModifiedAt())
                    .build();
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        userRepository.save(
                User.builder()
                        .userName(userRequest.getUserName())
                        .passWord(userRequest.getPassWord())
                        .firstName(userRequest.getFirstName())
                        .lastName(userRequest.getLastName())
                        .address(userRequest.getAddress())
                        .telephone(userRequest.getTelephone())
                        .createdAt(userRequest.getCreatedAt())
                        .modifiedAt(userRequest.getModifiedAt())
                        .build()
        );

    }

    @Override
    public void updateUser(UserRequest userRequest) {
        User user = User.builder()
                .id(userRequest.getId())
                .userName(userRequest.getUserName())
                .passWord(userRequest.getPassWord())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .address(userRequest.getAddress())
                .telephone(userRequest.getTelephone())
                .createdAt(userRequest.getCreatedAt())
                .modifiedAt(userRequest.getModifiedAt())

                .build();

        userRepository.save(user);


    }

    @Override
    public List<UserDto> getAll() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for(User user : users){

            UserDto userDto = UserDto.builder()
                    .userName(user.getUserName())
                    .passWord(user.getPassWord())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .address(user.getAddress())
                    .telephone(user.getTelephone())
                    .createdAt(user.getCreatedAt())
                    .modifiedAt(user.getModifiedAt())
                    .build();

            userDtos.add(userDto);

        }

        return userDtos;
    }

    @Override
    public void deleteUserById(Long id) {

        User user = userRepository.getUserById(id);

        userRepository.deleteById(id);

    }
}
