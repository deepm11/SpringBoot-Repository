package com.example.SpringCaching_D33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCachingD33Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCachingD33Application.class, args);
	}

}
