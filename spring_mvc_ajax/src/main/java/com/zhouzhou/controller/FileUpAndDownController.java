package com.zhouzhou.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author 周万宁
 * @className FileUpAndDownController
 * @create 2023/1/3-0:17
 * @description
 *
 *
 * 文件上传要求
 * 1.form表单的请求方式必须是post
 * 2.form表单必须设置属性enctype="nultipart/formdata"
 */
@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/down")
    @ResponseBody
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/img/R-C.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }


    @RequestMapping(value = "/test/up",method = RequestMethod.POST)
    @ResponseBody
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {

        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();

        //获取上传的文件的后缀名
        String hzName = fileName.substring(fileName.lastIndexOf("."),fileName.length());

        //获取uuid
        String uuid = UUID.randomUUID().toString();

        fileName = uuid + hzName;

        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();

        //获取当前工程下photo目录的真实路径
        String realPath = servletContext.getRealPath("photo");
        //创建photoPath所对应的file对象
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = realPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));

        return "success";
    }

}
