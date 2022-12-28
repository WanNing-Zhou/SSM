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


}
