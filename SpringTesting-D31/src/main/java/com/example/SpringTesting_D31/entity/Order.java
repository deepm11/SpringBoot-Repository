package com.example.SpringTesting_D31.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private double price;
    private int quantity;


    public Order() {}

    public Order( double price, int quantity) {

        this.price = price;
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
