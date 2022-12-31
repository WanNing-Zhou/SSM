package com.zhouzhou.spring.controller;

import com.zhouzhou.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 周万宁
 * @className UserService
 * @create 2022/12/31-4:55
 * @description
 */
@Controller("controller")
public class UserController {


    @Autowired(required = false)
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
