package com.example.FileHandling_D30.Repository;

import com.example.FileHandling_D30.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    Optional<FileEntity> findByFileName(String filename);
}
