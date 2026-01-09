package com.example.SpringAnnotation_D19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    @Value("BMW")
    private String Brand;

    @Value("250")
    private int MaxSpeed;


    @Autowired
    public Car(@Qualifier("dieselEngine")Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car Brand "+Brand);
        System.out.println("Car MaxSpeed "+MaxSpeed);

        System.out.println("Car is running");
    }
}