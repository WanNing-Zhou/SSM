package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 周万宁
 * @className ProtalController
 * @create 2023/1/1-22:49
 * @description
 */
@Controller
public class ProtalController {

    @RequestMapping("/")
    public String protal(){
        return "index";
    }
}
