package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周万宁
 * @className TestRestController
 * @create 2023/1/2-17:08
 * @description
 * 查询所有用户信息-->/user-->get
 * 根据id查询用户信息-->/user/1-->get
 * 添加用户信息-->/user/-->post
 * 修改用户信息-->/user-->put
 * 删除用户信息-->/user/1-->delete
 *
 *
 *
 */
@Controller
@RequestMapping("/user")
public class TestRestController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息-->/user-->get");
        return "success";
    }

   @RequestMapping(value = "/${id}",method = RequestMethod.GET)
   public String getUserById(){
       System.out.println("根据id查询用户信息-->/user/1-->get");
        return "success";
    }


}
