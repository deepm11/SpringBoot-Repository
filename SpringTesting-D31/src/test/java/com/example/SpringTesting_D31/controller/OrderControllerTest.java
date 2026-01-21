package com.example.SpringTesting_D31.controller;

import com.example.SpringTesting_D31.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void testCalculateTotal() throws Exception {

        when(orderService.calculateTotal(any()))
                .thenReturn(200.0);

        mockMvc.perform(post("/orders/total")
                        .contentType("application/json")
                        .content("{\"price\":100,\"quantity\":2}"))
                .andExpect(status().isOk())
                .andExpect(content().string("200.0"));
    }
}
