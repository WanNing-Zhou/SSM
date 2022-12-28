package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.SelectMapper;
import com.zhouzhou.mybatis.pojo.User;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className SelectMapperTest
 * @create 2022/12/28-23:01
 * @description 查询功能测试类
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(4);
        System.out.println(userById);
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }



    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testgetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(4);
        //{password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}
        System.out.println(userByIdToMap);
    }

    @Test
    public void testgetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String, Object>> list = mapper.getAllUserToMap();

        //{2={password=123, gender=女, id=2, age=23, email=12345@qq.com, username=root}, 4={password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}, 5={password=123456, gender=女, id=5, age=33, email=12345@qq.com, username=root}}
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }

}
