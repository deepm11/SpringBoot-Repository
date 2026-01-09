package com.example.SpringD2_A18;

public class Employee {

    private int Id;

    private String Name;

    private Department department;


    public Employee(int id, String name) {   ///constructor Based DI
        this.Id = id;
        this.Name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public void showEmployee(){
        System.out.println("emp id :"+ Id);
        System.out.println("Name:"+Name);
        System.out.println("dept:"+department.getDeptName());
    }

    // init method
    public void init() {
        System.out.println("Employee bean initialized");
    }

    // destroy method
    public void destroy() {
        System.out.println("Employee bean destroyed");
    }

}
