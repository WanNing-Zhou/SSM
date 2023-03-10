package com.zhouzhou.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.zhouzhou.ssm.pojo.Employee;
import com.zhouzhou.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 周万宁
 * @className EmployeeController
 * @create 2023/1/3-6:57
 * @description
 * 查询所有的员工信息 ->/employee---->get
 * 根据id查询员工信息 ->/employee/1---->get
 * 跳转到添加页面 ->/to/add---->get
 * 添加员工信息 ->/employee---->post
 * 修改员工信息 ->/employee---->get
 * 删除员工信息 ->/employee/1---->get
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping (value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list =  employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        return "employee_list";
    }

    //查询所有员工的分页信息

    @RequestMapping (value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        return "employee_list";
    }

}
