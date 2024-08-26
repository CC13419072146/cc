package com.furniture.shopping.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static String uploadFile(MultipartFile mFile, HttpServletRequest request) {
        String path = System.getProperty("user.dir") + "/upload";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String uuid = UUID.randomUUID().toString();
        String oldName = mFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        String newFileName = uuid.replace("-", "") + suffix;
        File newFile = new File(path + "\\" + newFileName);
        try {
            mFile.transferTo(newFile);
        } catch (Exception e) {
            log.error("file upload exception: {}", e);
        }
        return newFileName;
    }
}
