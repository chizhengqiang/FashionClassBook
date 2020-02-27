package com.conan.fashionclassbook.web;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.FileService;
import com.conan.fashionclassbook.service.UploadService;
import com.conan.fashionclassbook.service.impl.UploadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@Api(tags = "MultipartFileController-文件上传相关接口", description = "提供文件上传相关的 Rest API")
public class MultipartFileController {

    @Autowired
    FileService fileService;
    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    @ApiOperation("单文件上传")
    public ServerResponse<String> upload(@RequestParam(value = "file") MultipartFile file) {
        //填充业务
        ServerResponse<String> response = uploadService.uploadImage(file);
        return response;

    }

    @PostMapping("/uploads")
    @ApiOperation("多文件上传")
    public ServerResponse<String> uploads(@RequestParam("files") MultipartFile[] files) {
        return null;
    }
}
