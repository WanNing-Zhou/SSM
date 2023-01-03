package com.zhouzhou.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouzhou.ssm.mapper.EmployeeMapper;
import com.zhouzhou.ssm.pojo.Employee;
import com.zhouzhou.ssm.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 周万宁
 * @className EmployeeServiceImpl
 * @create 2023/1/3-7:07
 * @description
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNumber) {

        //page
        //开启分页功能
        PageHelper.startPage(pageNumber,8);
        //查询所有员工西悉尼
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
        return pageInfo;

    }
}
