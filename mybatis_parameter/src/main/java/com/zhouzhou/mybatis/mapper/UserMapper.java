package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.User;

import java.util.List;

/**
 * @author 周万宁
 * @className UserMapper
 * @create 2022/12/27-1:46
 * @description 用户mapper
 */
public interface UserMapper {

    /**
     * @MethodName insertUser
     * @Author 周万宁
     * @Description 添加用户信息
     * @Date 4:47 2022/12/27
     * @Param []
     * @return int
     **/
    int insertUser();

    /**
     * @MethodName updateUser
     * @Author 周万宁
     * @Description 修改用户信息
     * @Date 4:47 2022/12/27
     * @Param []
     * @return int
     **/
    int updateUser();

    /**
     * @MethodName deleteUser
     * @Author 周万宁
     * @Description 删除用户信息
     * @Date 4:51 2022/12/27
     * @Param []
     * @return int
     **/

    int deleteUser();

    /**
     * @MethodName getUserByID
     * @Author 周万宁
     * @Description 根据id查询用户信息
     * @Date 4:56 2022/12/27
     * @Param []
     * @return com.zhouzhou.mybatis.pojo.User
     **/
    User getUserByID();

    /**
     * @MethodName getAllUser
     * @Author 周万宁
     * @Description 查询所有的用户信息
     * @Date 5:08 2022/12/27
     * @Param []
     * @return java.util.List<com.zhouzhou.mybatis.pojo.User>
     **/
    List<User> getAllUser();

}
