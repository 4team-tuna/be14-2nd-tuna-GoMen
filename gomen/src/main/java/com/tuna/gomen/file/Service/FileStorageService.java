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
        // filename이 절대 경로일 경우, 올바른 상대 경로로 변환
        if (Paths.get(filename).isAbsolute()) {
            filename = new File(filename).getName(); // 파일명만 추출
        }

        // 경로를 안전하게 결합하고 정리
        Path filePath = Paths.get(fileStoragePath, filename).normalize();
        File file = filePath.toFile();

        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
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

}
