package com.zhouzhou.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 周万宁
 * @className ExceptionController
 * @create 2023/1/3-3:29
 * @description
 */
//将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex,Model model){
        //ex标识控制器方法所出现的异常
        model.addAttribute("ex",ex);
        return "success";
    }

}
