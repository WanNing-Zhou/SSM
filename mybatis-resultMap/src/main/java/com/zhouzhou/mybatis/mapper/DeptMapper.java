package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author 周万宁
 * @className DeptMapper
 * @create 2022/12/29-5:33
 * @description dept映射
 */
public interface DeptMapper {
    /**
     * @MethodName getEmpAndDeptByStepTwo
     * @Author 周万宁
     * @Description 通过分布查询员工以及对应的部门信息的第二部
     * @Date 5:35 2022/12/29
     * @Param []
     * @return com.zhouzhou.mybatis.pojo.Dept
     **/

    Dept getEmpAndDeptByStepTwo(@Param("deptId")Integer deptId);
}
