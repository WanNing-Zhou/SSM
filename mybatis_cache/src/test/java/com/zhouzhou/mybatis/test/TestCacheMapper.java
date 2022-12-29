package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.CacheMapper;
import com.zhouzhou.mybatis.pojo.Emp;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 周万宁
 * @className TestCacheMapper
 * @create 2022/12/30-4:27
 * @description 测试类
 */
public class TestCacheMapper {

    /**
     * mybatis的一级缓存
     * a.mybatis的一级缓存时sqlSession级别的,即通过同一个sqlSession查询的数据会被缓存
     * 再使用同一个sqlsession查询同一条数据,会从缓存中获取 默认开启的
     *
     *
     *
     *
     */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);

        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp3 = mapper.getEmpById(1);
        System.out.println(emp3);

    }

}
