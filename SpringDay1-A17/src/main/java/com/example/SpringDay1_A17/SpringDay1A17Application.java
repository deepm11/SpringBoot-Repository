package com.example.SpringDay1_A17;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDay1A17Application {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Car car = context.getBean("car", Car.class);
        car.Drive();

    }
}
