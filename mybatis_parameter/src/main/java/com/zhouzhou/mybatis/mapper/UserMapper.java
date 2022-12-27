package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className UserMapper
 * @create 2022/12/27-1:46
 * @description 用户mapper
 *
 * mybatis获取参数的值得两种方式:#{}和${}
 * 1.若mapper接口方法得参数为单个字面量类型
 * 此时可以通过#{}和${}以任意得内容获取参数值,一定要注意${}的单引号问题
 * 2.若mapper接口的方法的参数为多个字面量类型
 * 此时Mybatis会将参数放在map集合中,以两种方式存储数据
 * 1>以arg0,arg1...为键,以参数为值
 * b>以param1,param2..为键,以参数位置
 * 因此只需要通过#{}和${}
 * 3.若mappper接口方法的参数为map集合类型的参数
 * 只需要通过#{}和${}访问map集合的键,就可以获取相对应的值,一定要注意${}的单引号问题
 * 4.若mapper接口方法的参数为实体类的参数
 * 只需要通过#{}和${}访问实体类的属性名,就可以获取相对应的值,一定要注意${}的单引号问题
 *5.可以在mappper接口方法的参数上设置param注解
 * 此时MyVatis会将这些参数放在map中,以两种方式进行存储
 * a>以@param主机的value属性为键,以参数位置
 * b>以param1,param2...为键,以参数为值
 *
 *
 *
 */
public interface UserMapper {

    /**
     * @MethodName getUserByUsername
     * @Author 周万宁
     * @Description 根据用户名查询用户信息
     * @Date 1:16 2022/12/28
     * @Param [username]
     * @return com.zhouzhou.mybatis.pojo.User
     **/
    User getUserByUsername(String username);//用户注册

    /**
     * @MethodName checkLogin
     * @Author 周万宁
     * @Description 验证登录
     * @Date 1:34 2022/12/28
     * @Param [username, password]
     * @return com.zhouzhou.mybatis.pojo.User
     **/
    User checkLogin(String username,String password);

    /**
     * @MethodName chekLoginByMap
     * @Author 周万宁
     * @Description 验证登录
     * @Date 1:50 2022/12/28
     * @Param [map]
     * @return com.zhouzhou.mybatis.pojo.User
     **/

    User chekLoginByMap(Map<String,Object> map);

    /**
     * @MethodName insertUser
     * @Author 周万宁
     * @Description 添加用户信息的功能
     * @Date 1:56 2022/12/28
     * @Param [user]
     * @return int
     **/
    int insertUser(User user);


/**
 * @MethodName checkLoginByParam
 * @Author 周万宁
 * @Description 验证登录使用@param注解
 * @Date 2:10 2022/12/28
 * @Param [username, password]
 * @return com.zhouzhou.mybatis.pojo.User
 **/
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


}
