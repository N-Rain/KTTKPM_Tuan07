package com.iuh.userservice.controllers;

import com.iuh.userservice.models.User;
import com.iuh.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    List<User> getListUser(){
        return  userService.getListUser();
    }
    @GetMapping("/{id}")
    User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}
