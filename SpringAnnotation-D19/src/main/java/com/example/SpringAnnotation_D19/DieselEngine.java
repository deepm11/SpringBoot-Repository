package com.example.SpringAnnotation_D19;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {

    @Override
    public void start()
    {
        System.out.println("DieselEngine started");
    }
}
