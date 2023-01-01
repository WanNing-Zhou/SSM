package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周万宁
 * @className TestViewController
 * @create 2023/1/2-6:26
 * @description
 */
@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public  String testThymeleafView(){


        
        return "success";
    }



}
