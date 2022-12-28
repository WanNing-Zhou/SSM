package com.zhouzhou.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 周万宁
 * @className SqlSessionUtil
 * @create 2022/12/27-4:41
 * @description sqlSession工具类
 */
public class SqlSessionUtil {

    public  static SqlSession getSqlSession(){

        SqlSession sqlSession = null;
        //获取核心配置文件的输入流
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //获取SqlSessionFactory
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sqlSession对象
            sqlSession = sessionFactory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }


}
