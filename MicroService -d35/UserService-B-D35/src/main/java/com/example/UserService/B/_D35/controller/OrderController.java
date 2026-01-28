package com.example.UserService.B._D35.controller;

import com.example.UserService.B._D35.client.UserClient;
import com.example.UserService.B._D35.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

private final UserClient userClient;

public OrderController(UserClient userClient) {
    this.userClient = userClient;
}

@GetMapping("/order/user/{id}")
    public User getOrderWithUser(@PathVariable Long id)
    {
        return userClient.getUserById(id);
    }

}
