package com.zhouzhou.controller;

import com.zhouzhou.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 周万宁
 * @className HelloController
 * @create 2023/1/3-6:06
 * @description
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;


}
