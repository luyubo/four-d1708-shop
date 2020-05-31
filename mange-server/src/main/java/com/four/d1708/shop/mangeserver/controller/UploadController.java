package com.four.d1708.shop.mangeserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author luyubo
 * @Title: UploadController
 * @Package controller
 * @Description: 上传
 * @date 2020/5/30/1:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/mange")
public class UploadController {
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        //判断上传的文件
        try {
            if(file!=null && !file.isEmpty()){
                //上传路径地址
                String path="D:\\pic\\";
                //重新命名文件的名称
                String fileName= UUID.randomUUID()+"_"+file.getOriginalFilename();
                //创建文件对象
                File destFile=new File(path,fileName);
                //当前文件进行拷贝
                file.transferTo(destFile);
                return "http://localhost:8180/img/"+fileName;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }

}
