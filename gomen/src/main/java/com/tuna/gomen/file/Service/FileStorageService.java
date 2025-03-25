package com.tuna.gomen.file.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private final String fileStoragePath = "C:/uploads/"; // 파일 저장 경로

    public void deleteFile(String filename) {
        // 파일명에서 절대 경로 제거
        filename = Paths.get(filename).getFileName().toString();

        // 안전한 경로 생성
        Path filePath = Paths.get(fileStoragePath, filename).normalize();
        File file = filePath.toFile();

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + file.getPath());
            } else {
                System.out.println("File deletion failed: " + file.getPath());
            }
        } else {
            System.out.println("File does not exist: " + file.getPath());
        }
    }


    public String storeFile(MultipartFile file) throws IOException {
        // 파일 저장할 경로 설정
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(fileStoragePath+ uniqueFileName);

        // 파일 저장
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString(); // 저장된 파일의 경로 반환
    }

    public String storeFile(MultipartFile file, String storedFileName) {
        try {
            Path path = Paths.get(fileStoragePath).resolve(storedFileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return path.toString();
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 실패", e);
        }
    }

}
