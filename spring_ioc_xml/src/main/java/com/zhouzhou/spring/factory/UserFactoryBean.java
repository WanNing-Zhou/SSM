package com.zhouzhou.spring.factory;

import com.zhouzhou.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 周万宁
 * @className UserFactoryBean
 * @create 2022/12/31-4:39
 * @description
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
