package com.example.SpringJPA_D24.repository;

import com.example.SpringJPA_D24.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
