package com.example.SpringJPA_D24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
    @Table(name = "profile")
    public class Profile {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String email;
        private String phone;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
        private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
