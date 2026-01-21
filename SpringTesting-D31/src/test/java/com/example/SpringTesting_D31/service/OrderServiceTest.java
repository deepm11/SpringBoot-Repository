package com.example.SpringTesting_D31.service;

import com.example.SpringTesting_D31.entity.Order;
import com.example.SpringTesting_D31.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderServiceTest {

    private final OrderRepository repository = Mockito.mock(OrderRepository.class);

    private final OrderService service = new OrderService(repository);

    @Test
    void calculateTotal_validInput(){
        Order order = new Order(100,2);

        double result = service.calculateTotal(order);
        assertEquals(200.0,result);
    }

    @Test
    void calculateTotal_invalidQuantity() {
        Order order = new Order(100, 0);
        assertThrows(IllegalArgumentException.class,
                () -> service.calculateTotal(order));
    }
}
