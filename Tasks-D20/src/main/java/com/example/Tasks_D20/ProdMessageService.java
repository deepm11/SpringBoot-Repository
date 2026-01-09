package com.example.Tasks_D20;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")

public class ProdMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "Hello From PROD Profile!";
    }
}