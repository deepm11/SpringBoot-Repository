package com.example.SpringValidation_D23.dto;

import com.example.SpringValidation_D23.validation.ValidPhone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invaild email format")
    @NotBlank
    private String email;
    @Min(value = 18,message = "Age must be 18")
    private int age;
    @Size(min = 8, message = "password must be 8 character")
    private String password;
    @ValidPhone
    private String phone;


    //get N Set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
