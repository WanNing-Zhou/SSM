package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.UserMapper;
import com.zhouzhou.mybatis.pojo.User;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 周万宁
 * @className ParameterTest
 * @create 2022/12/28-1:22
 * @description mybatis传参的使用
 */
public class ParameterTest {
    @Test
    public void testGetUSerByUsername(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
        sqlSession.close();

    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");

        User user = mapper.chekLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUSer(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"root","123456",33,"女","12345@qq.com");

        mapper.insertUser(user);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testcheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.checkLoginByParam("admin","123456");

        System.out.println(user);
        sqlSession.close();
    }

}
