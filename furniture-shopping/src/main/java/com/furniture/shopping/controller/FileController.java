package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.service.UserService;
import com.furniture.shopping.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * 文件控制器
 */
@Controller
@RequestMapping("/api/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Resource
    private UserService userService;

    @PostMapping("/upload")
    @ResponseBody
    public ApiRestResponse<?> upload(@RequestParam("file") MultipartFile mFile, HttpServletRequest request) {
        /*
        *   首先获取上传标识(uploadFlag)，上传标识有如下几种:
        *       1: 表示用户修改头像
        * */
        String uploadFlag = request.getParameter("uploadFlag");
        String url = FileUtils.uploadFile(mFile, request);

        String userNo = request.getParameter("userNo");

        //修改用户头像，将用户头像的图片名保存到数据表
        if (uploadFlag != null && !uploadFlag.trim().equals("") && uploadFlag.equals("1")) {
            userService.updateAvatar(userNo, url);
        }
        //店铺上传商品图片
        if (uploadFlag != null && !uploadFlag.trim().equals("") && uploadFlag.equals("2")) {

        }
        //论坛交流上传图片

        return ApiRestResponse.success(url);
    }

    @GetMapping("/download")
    @ResponseBody
    public ApiRestResponse<?> download(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = request.getParameter("fileName");
            String realPath = System.getProperty("user.dir") + "/upload/" + fileName;
            File file = new File(realPath);
            response.setHeader("content-disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            InputStream in = new FileInputStream(file);
            byte[] buf = new byte[1024];
            while(in.read(buf) > 0) {
                response.getOutputStream().write(buf, 0, buf.length);
            }
            in.close();
            return ApiRestResponse.success("下载完成");
        } catch (Exception e) {
            log.error("download file exception: {}", e);
        }
        return ApiRestResponse.error("下载失败");
    }
}
