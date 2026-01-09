package com.example.Tasks_D20;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")                //if dev profile active bean loads

public class DevMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "Hello From Dev Profile!";
    }
}
