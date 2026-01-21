package com.example.SpringTesting_D31.controller;


import com.example.SpringTesting_D31.entity.Order;

import com.example.SpringTesting_D31.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping("/total")
    public double calculateTotal(@RequestBody Order order){
        return service.calculateTotal(order);
    }

}
