package com.example.SpringJPA_D24.controller;


import com.example.SpringJPA_D24.entity.Employee;
import com.example.SpringJPA_D24.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/save")
    public String  save(@RequestBody Employee emp) {
        repository.save(emp);
        return "Employee saved successfully";
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return repository.findAll();
    }

//   @PutMapping("/update")
//    public String  update(@RequestBody Employee emp) {
//        repository.save(emp);
//        return "Employee updated successfully";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        repository.deleteById(id);
//        return "Employee deleted successfully";
//    }
}
