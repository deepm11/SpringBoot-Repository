package com.example.SpringValidation_D23.controller;


import com.example.SpringValidation_D23.dto.UserRequest;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest request, BindingResult Result) {
        if (Result.hasErrors()){
            return ResponseEntity.badRequest().body(Result.getAllErrors());
        }
        return ResponseEntity.ok("user registered successfully");
    }
}
