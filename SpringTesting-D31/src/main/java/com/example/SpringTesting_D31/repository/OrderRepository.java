package com.example.SpringTesting_D31.repository;

import com.example.SpringTesting_D31.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
}
