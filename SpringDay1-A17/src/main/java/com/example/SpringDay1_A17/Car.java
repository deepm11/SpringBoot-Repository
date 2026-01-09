package com.example.SpringDay1_A17;

public class Car{

    private final Engine engine;

    //Constructor Injection
    public Car(Engine engine){
        this.engine=engine;                   //spring will pass the engine obj here
    }
    public void Drive(){
        engine.start();
        System.out.println(" Car is moving");
    }
}
