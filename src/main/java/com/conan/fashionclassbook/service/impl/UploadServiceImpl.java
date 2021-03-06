package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.config.UploadProperties;
import com.conan.fashionclassbook.service.UploadService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@Service
@EnableConfigurationProperties(UploadProperties.class)
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    UploadProperties prop;

    public ServerResponse<String> uploadImage(MultipartFile file) {
        //校验文件类型
        String contentType = file.getContentType();
        if (!prop.getAllowTypes().contains(contentType)) {
            //throw new RuntimeException("文件类型不支持");
            return ServerResponse.createByErrorMessage("文件类型不支持");
        }
        //校验文件内容
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null || image.getWidth() == 0 || image.getHeight() == 0) {
//                throw new RuntimeException("文件内容有问题");
                return ServerResponse.createByErrorMessage("文件内容有问题");
            }
        } catch (IOException e) {
            log.error("校验文件内容失败... {} ", e);
            //throw new RuntimeException("校验文件内容失败" + e.getMessage());
            return ServerResponse.createByErrorMessage("校验文件内容失败");
        }
        // 上传到到fastDFS中
        try {
            //获取扩展名
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            //上传
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            //返回路径
            return ServerResponse.createBySuccess(prop.getBaseUrl() + storePath.getFullPath());
        } catch (IOException e) {
            log.error("【文件上传】上传文件失败...{}", e);
           // throw new RuntimeException("【文件上传】上传文件失败...{}" + e.getMessage());
            return ServerResponse.createByErrorMessage("上传文件失败");
        }
    }
}


