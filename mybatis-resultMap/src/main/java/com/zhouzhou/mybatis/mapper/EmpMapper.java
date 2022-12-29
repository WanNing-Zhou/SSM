package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author 周万宁
 * @className EmpMapper
 * @create 2022/12/29-3:07
 * @description 员工mapper
 */
public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * @MethodName getEmpAndDeptByEmpId
     * @Author 周万宁
     * @Description 获取员工以及对应的部门信息
     * @Date 3:47 2022/12/29
     * @Param [empId]
     * @return com.zhouzhou.mybatis.pojo.Emp
     **/
    Emp getEmpAndDeptByEmpId(@Param("empId")Integer empId);


    /**
     * @MethodName getEmpAndDeptByStep
     * @Author 周万宁
     * @Description 查询员工以及所对应的部门信息的第一步
     * @Date 5:28 2022/12/29
     * @Param [empId]
     * @return com.zhouzhou.mybatis.pojo.Emp
     **/
    Emp getEmpAndDeptByStepOne(@Param("empId")Integer empId);


}
