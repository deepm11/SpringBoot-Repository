package com.example.SpringJPA_D24.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.List;

@Entity
    @Table(name = "project")
    public class Project {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String projectName;

        @ManyToMany(mappedBy = "projects")
        @JsonIgnore
        private List<Employee> employees;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
