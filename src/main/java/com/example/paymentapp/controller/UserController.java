package com.example.paymentapp.controller;

import com.example.paymentapp.dto.UserDto;
import com.example.paymentapp.dto.request.UserRequest;
import com.example.paymentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    final UserService userService;

    @GetMapping(value = "/userList")
    public List<UserDto> getUserInfo(){
        return userService.getAll();
    }

    @GetMapping(value = "/getUserById/{id}")
    public UserDto getUserById(@PathVariable (value = "id")Long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/saveUser")
    public void saveUser(@RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);
    }

    @PostMapping(value = "/updateUser")
    public void updateUser(@RequestBody UserRequest userRequest){
        userService.updateUser(userRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id){
        userService.deleteUserById(id);
    }


}
