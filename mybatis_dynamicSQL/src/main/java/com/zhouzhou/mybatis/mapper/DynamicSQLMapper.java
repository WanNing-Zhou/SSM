package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周万宁
 * @className DynamicSQLMapper
 * @create 2022/12/30-2:43
 * @description 动态sql映射接口
 */
public interface DynamicSQLMapper {

    /**
     * @MethodName getEmpByCondition
     * @Author 周万宁
     * @Description TODO
     * @Date 2:45 2022/12/30
     * @Param [emp]
     * @return java.util.List<com.zhouzhou.mybatis.pojo.Emp>
     **/
    List<Emp> getEmpByCondition( Emp emp);

    List<Emp> getEmpByChoose( Emp emp);

}
