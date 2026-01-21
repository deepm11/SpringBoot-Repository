package com.example.SpringTesting_D31.integration;

import com.example.SpringTesting_D31.entity.Order;
import com.example.SpringTesting_D31.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderIntegrationTest {

    @Autowired
    private OrderService service;

    @Test
    void testFullFlow() {
        Order order = new Order(50, 3);
        double total = service.calculateTotal(order);
        assertEquals(150, total);
    }
}
//hbjh
