package com.zhouzhou.mybatis.mapper;

import com.zhouzhou.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className SelectMapper
 * @create 2022/12/28-22:59
 * @description 查询功能
 * 若sql语句查询的结果为多条时,一定不能以实体类类型作为方法的返回值
 * 否则会抛出异常
 *
 * 若查询结果为多条,可以以实体类类型或list集合类型来作为方法的返回值
 *
 */
public interface SelectMapper {
    /**
     * @MethodName getUserById
     * @Author 周万宁
     * @Description 根据id查询用户信息
     * @Date 23:02 2022/12/28
     * @Param [id]
     * @return com.zhouzhou.mybatis.pojo.User
     **/
    User getUserById(@Param("id") Integer id);
    /**
     * @MethodName getAllUser
     * @Author 周万宁
     * @Description 查询所有的用户信息
     * @Date 23:14 2022/12/28
     * @Param []
     * @return java.util.List<com.zhouzhou.mybatis.pojo.User>
     **/

    List<User> getAllUser();

    /**
     * @MethodName getCount
     * @Author 周万宁
     * @Description 获取总数
     * @Date 23:15 2022/12/28
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getCount();

    /**
     * @MethodName getUserByIdToMap
     * @Author 周万宁
     * @Description 根据id查询用户信息为map集合
     * @Date 23:28 2022/12/28
     * @Param [id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * @MethodName getAllUserToMap
     * @Author 周万宁
     * @Description 查询所有用户信息为map集合
     * @Date 23:45 2022/12/28
     * @Param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     *  若查询的数据有多条时,并且要将每条数据转换为map集合
     *  此时有两种解决方案
     *  1.将mapper接口方法的返回值设置为list<map>
     *  2.可以将每条数据转换的map集合放在一个大的map中,但是必须要通过@Mapkey注解,
     *  将查询的某个字段的值作为大的map键
     * */

//    List<Map<String,Object>> getAllUserToMap();

    @MapKey("id")
    Map<String,Object> getAllUserToMap();



}
