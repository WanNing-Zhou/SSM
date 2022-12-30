package com.zhouzhou.spring.service.impl;

import com.zhouzhou.spring.dao.UserDao;
import com.zhouzhou.spring.service.UserService;

/**
 * @author 周万宁
 * @className UserServiceImpl
 * @create 2022/12/31-4:59
 * @description
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
