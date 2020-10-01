package com.springboot.controoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 周
 * @title FileUploadController
 * @date 2020/6/26 19:52
 * @description SpringBoot 基于MVC的文件上传
 * 默认文件上传限制大小为1MB
 */
@RestController
public class FileUploadController {

    /**
     * 文件上传
     *
     * @param file 参数名必须与fileupload.xml中的input标签的value值一致
     * @return
     * @throws IOException
     */
    @PostMapping("/fileUploadController")
    public String fileUpload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:/upload/" + file.getOriginalFilename()));
        return "OK";
    }
}
