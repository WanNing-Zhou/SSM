package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.SpecialSQLMapper;
import com.zhouzhou.mybatis.pojo.User;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author 周万宁
 * @className SpecialSQLMapperTest
 * @create 2022/12/29-0:47
 * @description 特殊sql测试
 */
public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("9,10");
    }


    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> t_user = mapper.getUserList("t_user");
        System.out.println(t_user);
    }




    public  void testJDBC(){
        try{
            Class.forName("");
            Connection connection = DriverManager.getConnection("", "", "");
            String sql = "";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            //获取自增的逐渐
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

        }catch(Exception e){

        }

    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "xiaoming", "123456", 23, "男", "123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
