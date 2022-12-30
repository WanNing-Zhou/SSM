package com.zhouzhou.spring.controller;

import com.zhouzhou.spring.service.UserService;
import com.zhouzhou.spring.service.impl.UserServiceImpl;

/**
 * @author 周万宁
 * @className UserService
 * @create 2022/12/31-4:55
 * @description
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public void saveUser(){
        userService.saveUser();
    }

}
