package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    ServerResponse<String> uploadImage(MultipartFile file);
}
