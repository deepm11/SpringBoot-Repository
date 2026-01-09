package com.example.JavaBasedConfiguration_D19;

public class Car {

    private Engine engine;

    //constructor injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive()
    {
        System.out.println(engine.start());
        System.out.println("car is moving");
    }

}
