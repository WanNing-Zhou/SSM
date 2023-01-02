package com.zhouzhou.controller;

import com.zhouzhou.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className TestAjaxController
 * @create 2023/1/2-20:42
 * @description
 * 1.@RequestBody:将亲求题中的内容和控制器方法的形参进行绑定
 * 2.@RequestBody注解将json格式的请求参数转换成java对象
 * a>jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-drivern/>
 * c>在处理请求的控制器方法的形参位置,直接设置json格式的请求参数要转换的java类型的形参,使用@requestbody注解即可
 * 3.@ResponseBody:将所表示的控制器方法的返回值作为响应报文的响应体相应到浏览器
 * 4.使用@ResponseBody注解响应到浏览器json格式的数据
 * a>jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-drivern/>
 * c>将需要转换为json字符串的java对象直接作为控制器方法的返回值,使用@ResponseBody注解标识控制器方法
 *
 * 常用的java对象转换为json的结果
 * 实体类->json对象
 * map->json对象
 * list->json数组
 *
 * @RestController 相当于@Controller + @ResponseBody
 *
 */
@Controller
public class TestAjaxController {

    @RequestMapping(value = "/test/ajax",method = RequestMethod.POST)
    public void testAjax(Integer id, @RequestBody String requstBody, HttpServletResponse response) throws IOException {
        System.out.println(requstBody);
        System.out.println(id);
        response.getWriter().write("hello,axios");
    }
    @RequestMapping(value = "/test/requestbody/json",method = RequestMethod.POST)
    public void testRequestBody(@RequestBody User user,HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,requestBody");

    }

    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,requestBody");

    }

    @RequestMapping("test/responsebody")
    @ResponseBody
    public String testResponseBody(){

        return "success";
    }

    @RequestMapping("/test/responsebody/json")
    @ResponseBody
    public User testResponseBodyJson(){

        User user = new User(1001, "admin", "12345", 20, "男");
        return user;
    }


    public Map<String,Object> testResponseBodyMap(){

        User user1 = new User(1001, "admin", "12345", 20, "男");
        User user2 = new User(1001, "admin", "12345", 20, "男");
        User user3 = new User(1001, "admin", "12345", 20, "男");
        Map<String,Object> map = new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);

        return map;
    }


    public List<User> testResponseBodyList(){

        User user1 = new User(1001, "admin", "12345", 20, "男");
        User user2 = new User(1001, "admin", "12345", 20, "男");
        User user3 = new User(1001, "admin", "12345", 20, "男");
        List<User> list = Arrays.asList(user1,user2,user3);

        return list;
    }

}
