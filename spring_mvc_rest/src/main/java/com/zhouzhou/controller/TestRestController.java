package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 * 注意:浏览器目前只能发送get和post请求
 * 若要发送put和delete请求,需要在web.xml配置一个过滤器HiddenHttpMethodFilter
 * 配置了过滤器之后,发送的请求需要满足两个条件,才能将请求方式转换为put或delete
 * 1.当前请求必须为post
 * 2.当前请求必须传输请求参数_method,._method的值才是最终的请求方式
 *
 *
 */
@Controller
@RequestMapping("/user")
public class TestRestController {

//    @RequestMapping(value = "",method = RequestMethod.GET)
    @GetMapping("")
    public String getAllUser(){
        System.out.println("查询所有用户信息-->/user-->get");
        return "success";
    }

//   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
   public String getUserById(@PathVariable("id") Integer id){
       System.out.println("根据id查询用户信息-->/user/"+id+"-->get");
        return "success";
    }

//    @RequestMapping(value = "",method = RequestMethod.POST)
    @PostMapping("")
    public String insertUser(){
        System.out.println(" * 添加用户信息-->/user/-->post");
        return "success";
    }


//    @RequestMapping(value = "",method = RequestMethod.PUT)
    @PutMapping
    public String updaeUser(){
        System.out.println(" 修改用户信息-->/user/-->put");
        return "success";
    }


//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping
    public String deleteUserById(@PathVariable("id") Integer id){
        System.out.println("根据id删除用户信息-->/user/"+id+"-->delete");
        return "success";
    }


}
