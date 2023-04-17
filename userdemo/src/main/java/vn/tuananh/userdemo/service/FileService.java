package vn.tuananh.userdemo.service;

import org.springframework.web.multipart.MultipartFile;
import vn.tuananh.userdemo.dto.FileResponse;

public interface FileService {
        FileResponse uploadFile(MultipartFile file);

        byte[] readFile(String id);
    }

