package vn.tuananh.userdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.tuananh.userdemo.dto.FileResponse;
import vn.tuananh.userdemo.exception.DuplicateRecordException;
import vn.tuananh.userdemo.exception.NotFoundUser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService {
    private final Path rootPath;

    public FileServiceImpl(@Value("root-path") String rootPathString) {
        rootPath = Paths.get(rootPathString);
        createFolder(rootPath);
    }

    private void createFolder(Path path) {
        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                log.error("Error when creating directory", e);
            }
        }
    }

    public FileResponse uploadFile(MultipartFile file) {
        validateFile(file);

        String fileId = UUID.randomUUID().toString();
        Path filePath = rootPath.resolve(fileId);// nối chuỗi vào đường dẫn
        File fileUpload = new File(filePath.toString());

        try (OutputStream outStream = new FileOutputStream(fileUpload)) {
            outStream.write(file.getBytes());
            return new FileResponse("/api/v1/files/" + fileId);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi trong quá trình upload file");
        }
    }

    private void validateFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        // Tên file không được trống
        if (fileName == null || fileName.isEmpty()) {
            throw new DuplicateRecordException("Tên file không hợp lệ");
        }

        // Type file có nằm trong ds cho phép hay không
        // avatar.png, image.jpg => png, jpg
        String fileExtension = getFileExtension(fileName);
        if (!checkFileExtension(fileExtension)) {
            throw new DuplicateRecordException("Type file không hợp lệ");
        }

        // Kích thước size có trong phạm vi cho phép không
        double fileSize = (double) (file.getSize() / 1_048_576);
        if (fileSize > 2) {
            throw new DuplicateRecordException("Size file không được vượt quá 2MB");
        }
    }

    public String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex + 1);
    }

    public boolean checkFileExtension(String fileExtension) {
        List<String> fileExtensions = List.of("png", "jpg", "jpeg");
        return fileExtensions.contains(fileExtension);
    }

    public byte[] readFile(String id) {
        Path filePath = rootPath.resolve(id);
        File file = new File(filePath.toString());

        if (!file.exists()) {
            throw new NotFoundUser("Not found file id = " + id);
        }

        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi trong quá trình đọc file");
        }
    }
}