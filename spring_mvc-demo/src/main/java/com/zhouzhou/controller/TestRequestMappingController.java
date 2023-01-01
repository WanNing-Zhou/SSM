package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周万宁
 * @className TestRequestMappingController
 * @create 2023/1/1-22:48
 * @description
 *
 * 1.@RequestMapping注解标识的位置
 * @RequestMapping标识一个类:设置映射请求的请求路径的基础信息
 * @RequestMapping标识一个方法:设置映射请求路径的具体信息
 *
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {
    //此时控制器方法所匹配的请求的请求路径设置为/test/hello
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
