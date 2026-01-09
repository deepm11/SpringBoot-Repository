package com.example.SpringJPA_D24.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.example.SpringJPA_D24.entity.Profile;


import java.util.List;

@Entity
@Table(name ="employee")



public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private double salary;



    // OneToOne (Employee → Profile)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
     @JsonIgnore
    private Profile profile;

        //ManyToOne (Employee → Department)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
      @JsonIgnore
    private Department department;

// ManyToMany (Employee ↔ Project)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
      @JsonIgnore
    private List<Project> projects;





        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }



    }

