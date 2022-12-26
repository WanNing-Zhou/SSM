package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.UserMapper;
import com.zhouzhou.mybatis.pojo.User;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 周万宁
 * @className MyBatisTest
 * @create 2022/12/27-1:58
 * @description MyBatis使用测试
 */
public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        //1.获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //3.获取SqlSessionFactory对象

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //4.获取sql的会话对象SqlSession,时MyBatis提供的曹祖数据库的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交事务

       SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务
        //5.获取UserMapper的代理实现类对象 代理模式 创建实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //6.调用mapper接口中的方法,实现添加用户信息的功能
        int i = mapper.insertUser();


//        //提供sql以及的唯一表示找到sql并执行,唯一标识时namespace.sqlID.sqlID
//        sqlSession.insert("com.zhouzhou.mybatis.mapper.UserMapper.insertUser");


        System.out.println("结果"+i);
        //7.提交事务
//        sqlSession.commit();
        //关闭sqlsession
        sqlSession.close();


    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }


    @Test
    public  void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }


    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByID();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);

        sqlSession.close();
    }

}
