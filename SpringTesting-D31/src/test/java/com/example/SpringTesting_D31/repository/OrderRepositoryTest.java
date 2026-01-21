package com.example.SpringTesting_D31.repository;

import com.example.SpringTesting_D31.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class OrderRepositoryTest  {



    @Autowired
    private OrderRepository repository;

    @Test
    void testSaveAndFind() {
        Order order = new Order(100, 2);
        Order saved = repository.save(order);
        assertNotNull(saved);
    }
}
