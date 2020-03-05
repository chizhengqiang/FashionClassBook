package com.conan.fashionclassbook.service.impl;

import com.conan.fashionclassbook.commons.Const;
import com.conan.fashionclassbook.commons.Constants;
import com.conan.fashionclassbook.commons.ServerResponse;
import com.conan.fashionclassbook.service.FileService;
import com.conan.fashionclassbook.utils.FTPUtil;
import com.conan.fashionclassbook.utils.PropertiesUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    /**
     * 但文件上传
     *
     * @param file
     * @return 文件上传地址
     */
    @Override
    public ServerResponse<File> upload(MultipartFile file) {
        if (file.isEmpty()) {
            return ServerResponse.createByErrorMessage(Constants.Files.CAN_NOT_FIND_RECORD);
        }
        //文件名称
        String fileName = file.getOriginalFilename();
        //文件上传地址
        String fileUploadAddress = PropertiesUtil.getProperty(Const.FILE_PATH_URL);

        File fileInfo = new File(fileUploadAddress + "/" + fileName);

        if (!fileInfo.exists()) {
            fileInfo.mkdirs();
        }

        try {
            file.transferTo(fileInfo);
        } catch (IOException e) {
            log.error("上传文件失败： {}", e);
            return ServerResponse.createByErrorMessage(Constants.Files.UPLOAD_FAIR);
        }
        return ServerResponse.createBySuccess(Constants.Files.UPLOAD_SUCCESS, fileInfo);

    }

    /**
     * @param file
     * @return 文件地址
     */
    public ServerResponse<String> uploadToFtp(MultipartFile file) {
        //文件名
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
        String uploadFileName = UUID.randomUUID().toString() + fileExtensionName;

        String path = PropertiesUtil.getProperty("multipartfile.filePath");

        log.info("开始上传文件，上传文件的文件名:{}, 上传路径:{},新文件名:{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);

            // 将targetFile 上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            // 上传完成后，删除upload下面的文件
            targetFile.delete();

        } catch (IOException e) {
            log.error("上传文件异常", e);
            return ServerResponse.createByErrorMessage(Constants.Files.UPLOAD_FAIR);
        }

        return ServerResponse.createBySuccess(Constants.Files.UPLOAD_SUCCESS, PropertiesUtil.getProperty("ftp.server.http.prefix") + uploadFileName);

    }
}
