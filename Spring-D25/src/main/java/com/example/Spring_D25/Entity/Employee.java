package com.example.Spring_D25.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    private String name;
    private String department;
    private double salary;

    //auditing fields
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


    public Employee() {}

    public Employee( String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;

    }


}
