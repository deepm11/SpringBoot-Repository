package com.example.SpringTesting_D31.service;

import com.example.SpringTesting_D31.repository.OrderRepository;
import com.example.SpringTesting_D31.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public double calculateTotal(Order order){
        if(order.getQuantity()<=0){
            throw new IllegalArgumentException("Order Quantity Must Be Positive");
        }
        return order.getPrice()*order.getQuantity();
    }

    public Order saveOrder(Order order){
        return repository.save(order);
    }


}
