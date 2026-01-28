package com.example.UserService.B._D35.client;

import com.example.UserService.B._D35.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public User getUserById(Long id)
    {
        return restTemplate.getForObject("http://localhost:8081/users/"+id,User.class);
    }


}
