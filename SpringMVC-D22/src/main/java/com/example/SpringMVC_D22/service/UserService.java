package com.example.SpringMVC_D22.service;


import com.example.SpringMVC_D22.Dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserDTO> users = new ArrayList<>();

    public UserDTO addUser(UserDTO user){
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserById(Long  id){
        return users.stream()
                .filter(u -> u.getId().equals(id)).
                findFirst().orElse(null);
    }

}
