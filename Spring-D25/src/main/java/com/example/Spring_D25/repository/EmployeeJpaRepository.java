package com.example.Spring_D25.repository;

import com.example.Spring_D25.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Scanner;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryBetween(double min, double max);

    List<Employee> findByNameLike(String pattern);

    List<Employee> findByDepartmentOrderBySalaryDesc(String department);

//JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findHighSalary(@Param("salary") double salary);

    //NATIVE QUERY
    @Query(value = "SELECT * FROM employees WHERE department = ?1", nativeQuery = true)
    List<Employee> findByDepartmentNative(String department);




}
