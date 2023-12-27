package com.example.Backend;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api")
public class FileController {

    private static final String UPLOADS_DIR = "uploads";
    private static final String METADATA_FILE = "file_metadata.json";

    @GetMapping("/files")
    public ResponseEntity<List<FileMetadata>> getUploadedFiles() {
        // retrieve file metadata from JSON file
        List<FileMetadata> metadataList = retrieveFileMetadata();
        return ResponseEntity.ok(metadataList);
    }
    @GetMapping("/file/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable String fileName) {
        try {
            Path filePath = Path.of(UPLOADS_DIR, fileName);

            if (Files.exists(filePath)) {
                byte[] fileContent = Files.readAllBytes(filePath);

                // determine the content type based on the file extension
                MimeType mimeType = MimeTypeUtils.parseMimeType(Files.probeContentType(filePath));
                String contentType = mimeType != null ? mimeType.toString() : org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

                return ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
                        .body(fileContent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error fetching file.");
        }
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String sanitizedFileName = file.getOriginalFilename();
            Path filePath = Path.of(UPLOADS_DIR, sanitizedFileName);
// not sure whether to disable uploading already uploaded files or not
//
//            if (Files.exists(filePath)) {
//                System.out.println("File already exists: " + filePath.toString());
//                return ResponseEntity.badRequest().body("File already exists.");
//            }

            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            saveFileMetadata(sanitizedFileName, file.getSize());

            // Return the list of all uploaded files after successful upload
            List<FileMetadata> metadataList = retrieveFileMetadata();
            return ResponseEntity.ok(metadataList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading file.");
        }
    }

    private void saveFileMetadata(String fileName, long fileSize) {
        List<FileMetadata> metadataList = retrieveFileMetadata();
        metadataList.add(new FileMetadata(fileName, fileSize));
        saveMetadataToFile(metadataList);
    }

    private List<FileMetadata> retrieveFileMetadata() {
        try {
            Path metadataFilePath = Path.of(METADATA_FILE);

            if (Files.exists(metadataFilePath)) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(metadataFilePath.toFile(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, FileMetadata.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private void saveMetadataToFile(List<FileMetadata> metadataList) {
        try {
            Path metadataFilePath = Path.of(METADATA_FILE);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(metadataFilePath.toFile(), metadataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


