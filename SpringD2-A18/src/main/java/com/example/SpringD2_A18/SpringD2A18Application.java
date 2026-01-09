package com.example.SpringD2_A18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringD2A18Application {

	public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Employee emp1 = (Employee) context.getBean("emp");

        emp1.showEmployee();

        Employee emp2 = (Employee) context.getBean("emp");
        emp2.showEmployee();

       // System.out.println(emp1 == emp2);  //singleton if true

        //close container
        context.close();


	}

}
