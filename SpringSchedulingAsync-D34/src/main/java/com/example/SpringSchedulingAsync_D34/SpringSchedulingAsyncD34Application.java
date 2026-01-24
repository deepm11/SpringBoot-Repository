package com.example.SpringSchedulingAsync_D34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringSchedulingAsyncD34Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulingAsyncD34Application.class, args);
	}

}
