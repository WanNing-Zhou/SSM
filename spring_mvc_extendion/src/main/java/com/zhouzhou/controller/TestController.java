package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 周万宁
 * @className TestController
 * @create 2023/1/3-1:57
 * @description
 */
@Controller
public class TestController {
    @RequestMapping("/test/hello")
//    @ResponseBody
    public String testHello() {
        System.out.println(1/0);
        return "success";
    }
}
