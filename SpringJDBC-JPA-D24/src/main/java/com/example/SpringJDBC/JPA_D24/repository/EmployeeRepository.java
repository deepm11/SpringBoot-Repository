package com.example.SpringJDBC.JPA_D24.repository;


import com.example.SpringJDBC.JPA_D24.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int save (Employee emp) {
         String sql ="INSERT INTO employee (name, salary) VALUES (?,?)";

         return  jdbcTemplate.update(sql,emp.getName(),emp.getSalary());
    }

    public List<Employee> findAll() {
        String sql ="SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int upadate(Employee emp) {
        String sql="UPDATE employee SET name=?, salary=? WHERE id=?";

        return jdbcTemplate.update(sql,emp.getName(),emp.getSalary(),emp.getId());
    }

    public int delete (int id) {
        String sql ="DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }


}
