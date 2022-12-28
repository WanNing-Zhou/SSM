package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周万宁
 * @className SpecialSQLMapper
 * @create 2022/12/29-0:43
 * @description mybatis执行特殊sql
 */
public interface SpecialSQLMapper {

    /**
     * @MethodName getUserByLike
     * @Author 周万宁
     * @Description 模糊查询
     * @Date 0:46 2022/12/29
     * @Param [mohu]
     * @return java.util.List<com.zhouzhou.mybatis.pojo.User>
     **/
    List<User> getUserByLike(@Param("mohu") String mohu);


    /**
     * @MethodName deleteMoreUser
     * @Author 周万宁
     * @Description 批量删除
     * @Date 1:06 2022/12/29
     * @Param [ids]
     * @return void
     **/
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * @MethodName getUserList
     * @Author 周万宁
     * @Description 动态设置表名
     * @Date 1:13 2022/12/29
     * @Param [tablename]
     * @return java.util.List<com.zhouzhou.mybatis.pojo.User>
     **/
    List<User> getUserList(@Param("tablename") String tablename);

    //添加功能获取自增的主键
    /**
     * @MethodName insertUser
     * @Author 周万宁
     * @Description 添加用户信息并获取自增逐渐
     * @Date 1:28 2022/12/29
     * @Param [user]
     * @return void\
     *
     **/
    void insertUser(User user);

}
