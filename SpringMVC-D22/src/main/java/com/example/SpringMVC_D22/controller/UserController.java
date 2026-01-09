package com.example.SpringMVC_D22.controller;


import com.example.SpringMVC_D22.Dto.UserDTO;
import com.example.SpringMVC_D22.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

     private final UserService Service;

     public UserController(UserService Service){
         this.Service = Service;
     }

     @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){

         UserDTO saved = Service.addUser(user);
         return new ResponseEntity<>(saved, HttpStatus.CREATED);

     }

     @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
         return ResponseEntity.ok(Service.getAllUsers());
     }

     @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
         UserDTO user=Service.getUserById(id);
         return ResponseEntity.ok(user);
     }


}
