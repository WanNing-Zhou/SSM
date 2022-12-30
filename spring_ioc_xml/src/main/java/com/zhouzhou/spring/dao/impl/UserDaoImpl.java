package com.zhouzhou.spring.dao.impl;

import com.zhouzhou.spring.dao.UserDao;

/**
 * @author 周万宁
 * @className UserDaoImpl
 * @create 2022/12/31-4:57
 * @description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
