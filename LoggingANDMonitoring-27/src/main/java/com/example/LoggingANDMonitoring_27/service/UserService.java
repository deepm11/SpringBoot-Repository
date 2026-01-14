package com.example.LoggingANDMonitoring_27.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public String findUser(int id) {
        logger.debug("Finding user with id: {}", id);


        if (id <= 0) {
            logger.error("Invalid user id: {}", id);
            return "Invalid user";
        }


        logger.info("User found successfully: {}", id);
        return "User id = " + id;
    }
}
