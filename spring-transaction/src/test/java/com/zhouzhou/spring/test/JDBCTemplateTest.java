package com.zhouzhou.spring.test;

import com.zhouzhou.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 周万宁
 * @className JDBCTemplateTest
 * @create 2023/1/1-3:30
 * @description
 */
//指定当前测试类在Spring的测试环境中执行,此时就可以同过注入的方法直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")


public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"root","123",23,"女","123456@qq.com");

    }

    @Test
    public void testGetUserById(){
        String sql = "select * from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);

    }


    @Test
    public void testGetAllUser(){
        String sql = "select * from t_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }

    @Test
    public void testGetCount(){
        String sql = "select count(*) from t_user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }




}
