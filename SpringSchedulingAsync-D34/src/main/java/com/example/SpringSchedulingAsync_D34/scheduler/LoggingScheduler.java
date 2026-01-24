package com.example.SpringSchedulingAsync_D34.scheduler;

import com.example.SpringSchedulingAsync_D34.async.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoggingScheduler {

private final NotificationService  notificationService;

public LoggingScheduler(NotificationService notificationService) {
    this.notificationService = notificationService;
}
//Run every 10 min

    @Scheduled(cron = "0 */1 * * * ?")
    public void LogData()
    {
        System.out.println("Scheduler is running on thread: " + Thread.currentThread().getName());

        //call async method
        notificationService.sendNotification();

    }
}
