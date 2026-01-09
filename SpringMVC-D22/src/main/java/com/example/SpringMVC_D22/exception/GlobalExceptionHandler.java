package com.example.SpringMVC_D22.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationError() {
    return ResponseEntity.badRequest().body("Invalid input Data");
}


}
