package com.example.LoggingANDMonitoring_27.controller;

import com.example.LoggingANDMonitoring_27.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        logger.info("Received request for user id: {}", id);


        String result = userService.findUser(id);


        logger.info("Sending response for user id: {}", id);
        return result;
    }
}
