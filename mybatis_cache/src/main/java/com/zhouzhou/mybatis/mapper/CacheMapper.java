package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author 周万宁
 * @className CacheMapper
 * @create 2022/12/30-4:25
 * @description 接口
 */
public interface CacheMapper {

    Emp getEmpById(@Param("empId") Integer empId);
}
