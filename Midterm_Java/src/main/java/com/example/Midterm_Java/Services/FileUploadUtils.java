package com.example.Midterm_Java.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;


public class FileUploadUtils {
//    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
//    public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
//        Path staticPath = Paths.get("static");
//        Path imagePath = Paths.get("images");
//        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//        }
//        Path file = CURRENT_FOLDER.resolve(staticPath)
//                .resolve(imagePath).resolve(fileName);
//        try (OutputStream os = Files.newOutputStream(file)) {
//            os.write(multipartFile.getBytes());
//        }
//    }
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

}
