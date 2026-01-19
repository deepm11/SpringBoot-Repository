package com.example.FileHandling_D30.Service;

import com.example.FileHandling_D30.Entity.FileEntity;
import com.example.FileHandling_D30.Repository.FileRepository;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public FileEntity uploadFile(MultipartFile file) throws Exception {
        if (file.isEmpty()
        ) {

            throw new RuntimeException("File is empty");
        }


        String contentType = file.getContentType();
        if (!contentType.equals("image/png") &&
                !contentType.equals("image/jpeg") &&
                !contentType.equals("application/pdf")) {
            throw new RuntimeException("File type not supported");
        }

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


        FileEntity entity = new FileEntity();
        entity.setFileName(file.getOriginalFilename());
        entity.setFileSize(file.getSize());
        entity.setFileType(file.getContentType());
        entity.setFilePath(uploadPath.toString());

        return fileRepository.save(entity);

    }

    public Resource downloadFile(String fileName) throws Exception {

        FileEntity entity = fileRepository.findByFileName(fileName)
                .orElseThrow(() -> new Exception("File not found"));

        Path path = Paths.get(entity.getFilePath());
        return new UrlResource(path.toUri());
    }

}

