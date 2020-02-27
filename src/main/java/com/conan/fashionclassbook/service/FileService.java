package com.conan.fashionclassbook.service;

import com.conan.fashionclassbook.commons.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {

    ServerResponse<File> upload(MultipartFile file);

    ServerResponse<String> uploadToFtp(MultipartFile file);
}
