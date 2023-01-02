package com.zhouzhou.controller;

import com.zhouzhou.dao.EmployeeDao;
import com.zhouzhou.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author 周万宁
 * @className EmployeeController
 * @create 2023/1/2-18:36
 * @description
 *
 * 查询所有的员工信息-->/employee===>get
 * 跳转到添加页面-->/to/add-->get
 * 新增所有的员工信息-->/employee===>post
 * 跳转到修改页面-->/employee/1-->get
 * 修改员工信息-->/employee===>put
 * 删除员工信息->/to/add-->delete
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //获取所有的员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployee",allEmployee);

        return "employee_list";
    }


}
