package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周万宁
 * @className HelloController
 * @create 2023/1/1-21:37
 * @description
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String protal(){

        //将逻辑视图返回
        return"index";

    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }


}
