package com.example.SpringJPA_D24.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
    @Table(name = "department")
    public class Department {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String deptName;

        @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
        @JsonIgnore
        private List<Employee> employees;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }



    }
