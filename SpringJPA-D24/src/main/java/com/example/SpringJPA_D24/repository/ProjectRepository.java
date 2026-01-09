package com.example.SpringJPA_D24.repository;

import com.example.SpringJPA_D24.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
