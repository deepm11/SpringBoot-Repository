package com.example.SpringJDBC.JPA_D24.controller;

import com.example.SpringJDBC.JPA_D24.model.Employee;
import com.example.SpringJDBC.JPA_D24.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/save")
    public String  save(@RequestBody Employee emp) {
        repository.save(emp);
        return "Employee saved successfully";
    }

    @GetMapping("/all")
    public List<Employee> getall() {
        return repository.findAll();
    }

    @PutMapping("/update")
    public String  update(@RequestBody Employee emp) {
        repository.upadate(emp);
        return "Employee updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        repository.delete(id);
        return "Employee deleted successfully";
    }

}
