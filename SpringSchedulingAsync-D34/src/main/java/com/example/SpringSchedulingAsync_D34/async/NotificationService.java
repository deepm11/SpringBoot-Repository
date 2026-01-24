package com.example.SpringSchedulingAsync_D34.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async
    public void sendNotification() {
        try {
            System.out.println(" Notification started on thread : " + Thread.currentThread().getName() );

            Thread.sleep(30000);

            System.out.println(" Notification ended on thread : " + Thread.currentThread().getName() );


        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
