package com.zhouzhou.ssm.mapper;

import com.zhouzhou.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 周万宁
 * @className EmployeeMapper
 * @create 2023/1/3-18:18
 * @description
 */
public interface EmployeeMapper {


    List<Employee> getAllEmployee();

}
