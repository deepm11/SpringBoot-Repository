package com.example.Spring_D25.repository;

import com.example.Spring_D25.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee,Long> {

    void flush();
}



