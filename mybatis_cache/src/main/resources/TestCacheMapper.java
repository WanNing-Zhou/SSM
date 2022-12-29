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
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);


    }

}
