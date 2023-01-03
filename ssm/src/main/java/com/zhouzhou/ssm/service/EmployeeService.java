package com.zhouzhou.ssm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhouzhou.ssm.pojo.Employee;

import java.util.List;

/**
 * @author 周万宁
 * @className EmployeeService
 * @create 2023/1/3-7:06
 * @description
 */
public interface EmployeeService {

    /**
     *查询所有的员工信息
     */
    List<Employee> getAllEmployee();

   PageInfo<Employee> getEmployeePage(Integer pageNumber);

}
