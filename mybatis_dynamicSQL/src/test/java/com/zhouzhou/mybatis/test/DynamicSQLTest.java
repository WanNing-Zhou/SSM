package com.zhouzhou.mybatis.test;

import com.zhouzhou.mybatis.mapper.DynamicSQLMapper;
import com.zhouzhou.mybatis.pojo.Emp;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 周万宁
 * @className DynamicSQLTest
 * @create 2022/12/30-2:47
 * @description 动态sql测试
 */
public class DynamicSQLTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"张三",20,"");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        System.out.println(empByCondition);
    }

    @Test
    public void testgetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"张三",20,"");
        List<Emp> emps = mapper.getEmpByChoose(emp);
        System.out.println(emps);
    }

}
