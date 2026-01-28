package com.example.UserService_D35;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable Long id)
    {
        return new User(id,"Dell","Delll@gmail.com");
    }

}
