package com.example.FileHandling_D30.Controller;

import com.example.FileHandling_D30.Entity.FileEntity;
import com.example.FileHandling_D30.PdfGenerator;
import com.example.FileHandling_D30.Service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileEntity> upload(@RequestParam("file") MultipartFile file) throws Exception {
        FileEntity saved = fileService.uploadFile(file);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName) throws Exception {

        Resource resource = fileService.downloadFile(fileName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/image/{fileName}")
    public ResponseEntity<Resource> viewImage(@PathVariable String fileName) throws Exception {
        Resource resource = fileService.downloadFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<Resource> generatePdf() throws Exception {

        String path = PdfGenerator.generatePdf("Hello PDF from Spring Boot");

        Resource resource = new UrlResource(Paths.get(path).toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=report.pdf")
                .body(resource);


    }
}
