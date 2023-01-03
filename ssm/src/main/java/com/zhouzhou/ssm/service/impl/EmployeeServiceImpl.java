package com.zhouzhou.ssm.service.impl;

import com.zhouzhou.ssm.mapper.EmployeeMapper;
import com.zhouzhou.ssm.pojo.Employee;
import com.zhouzhou.ssm.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
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
}
