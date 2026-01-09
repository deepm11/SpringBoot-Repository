package com.example.SpringBoot_D21.controller;


import com.example.SpringBoot_D21.Service.UserService;
import com.example.SpringBoot_D21.dto.UserDto;
import com.example.SpringBoot_D21.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // GET all users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    // POST create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto dto) {
        User user = service.createUser(dto);
        return ResponseEntity.status(201).body(user);
    }

    // PUT update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody UserDto dto) {

        User updated = service.updateUser(id, dto);
        if (updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        boolean deleted = service.deleteUser(id);
        if (!deleted)
            return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }
}