package com.zhouzhou.controller;

import com.zhouzhou.dao.EmployeeDao;
import com.zhouzhou.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);

        //重定向到表单功能:/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工西悉尼共享到请求域钟
        model.addAttribute("employee",employee);
        //跳转到employee_update
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);

        //重定向到表单功能:/employee
        return "redirect:/employee";
    }


    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/employee";

    }


}
