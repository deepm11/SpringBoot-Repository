package com.example.Spring_Expn_D26.controller;


import com.example.Spring_Expn_D26.Exception.ResourceNotFoundException;
import com.example.Spring_Expn_D26.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private List<User> users = List.of(
            new User(1, "Ravi"),
            new User(2, "Amit")
    );

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {

        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + id)
                );
    }


}
