package com.zhouzhou.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouzhou.mybatis.mapper.EmpMapper;
import com.zhouzhou.mybatis.pojo.Emp;
import com.zhouzhou.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 周万宁
 * @className PageTest
 * @create 2022/12/30-22:00
 * @description 测试分页插件
 */
public class PageTest {

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);

        List<Emp> list = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> empPageInfo = new PageInfo<>(list, 2);
        list.forEach(System.out::println);
        System.out.println(empPageInfo);

    }


}
