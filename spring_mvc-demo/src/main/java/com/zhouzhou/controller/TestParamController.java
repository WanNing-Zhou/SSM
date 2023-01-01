package com.zhouzhou.controller;

import com.zhouzhou.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 周万宁
 * @className TestParamController
 * @create 2023/1/2-0:48
 * @description
 *
 * 1.通过ServletAPI获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest
 * 就可以在控制器方法中使用request对象获取请求桉树
 *
 * 2.通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置,设置一个形参,形参的名字要和请求参数的名字一致即可
 *
 * 3.@RequestParam:将请求参数和控制器方法的形参绑定
 * @RequestParam注解的三个属性:value,required,defaultValue
 * value:设置和形参绑定的请求参数的名字
 * required:设置是否传输value所对应的请求参数,默认值为true
 *  表示value所对应的请求参数必须传输,否则页面报错
 *  若设置为false,则表示value所对应的参数不是必须传输,若未参数,则形参值未null
 * defaultValue:设置当没有传输value所对应的请求参数是,为形参设置的默认值,此时和required属性值false一起使用
 *  4.@RequestHeader:将请求头信息和控制器方法的形参绑定
 *  5.@CookieValue:将cookie数据和控制器方法的形参绑定
 *  6.通过控制器方法的实体类类习惯的形参获取请求参数
 *  需要在控制器方法的形参位置设置实体类类型的形参,要保证实体类中的属性名和请求参数的名字保持一致
 *  可以通过实体类类型的形参获取参数
 *  7.解或获取请求参数的乱码问题
 *  在web.xml中配置spring的编码过滤器CharacterEncodingFilter
 *  注意:SpringMVC中处理编码的过滤器一定要配置到其他过滤器之前,否则无效
 *
 */
@Controller
public class TestParamController {

    @RequestMapping(value = "/param/servletAPI",method= {RequestMethod.POST,RequestMethod.GET})
    public String getParamByServletAPI(HttpServletRequest request){


        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username"+username);
        System.out.println("password"+password);
        return "success";
    }

    @RequestMapping(value = "/param",method = RequestMethod.POST)
    public String getParam(@RequestParam(value="username",defaultValue ="张三",required = false) String name,
                           String password,
                           @RequestHeader(value = "referer",required = false) String referer,
                           @CookieValue("JSESSIONID") String jessionId

    ){

        System.out.println("referer"+referer);
        System.out.println("cookie:" + jessionId);
        System.out.println("username"+name);
        System.out.println("password"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}
