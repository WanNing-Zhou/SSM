package com.zhouzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 周万宁
 * @className TestScopeDController
 * @create 2023/1/2-3:56
 * @description
 * 1.通过ModelAndView向请求域共享数据
 * 使用ModelAndView时,可以使用其Model功能项向请求域共享数据
 * 使用view功能功能设置逻辑视图,但是控制方法一定要将ModelView作为方法的返回值
 * 2.使用Model向请求域共享数据
 * 3使用ModelMap向请求域共享数据
 *  4使用map向请求域中共享数据
 *  5.Model和ModelMap和map的关系
 *  其实在底层中,这些类型的形参最终都是通过BindingAwareModelMap创建
 *
 */
@Controller
public class TestScopeDController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * model and view 包含model和view的功能
         * model:向请求域中共享数据
         *  view:设置逻辑视图来实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        ModelAndView testRequestScope = mav.addObject("testRequestScope", "hello,modelandview");

        //设置逻辑视图
        mav.setViewName("success");
        return mav;

    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "sucess";
    }

    @RequestMapping("/test/modelmap")
    public String testModelMap(ModelMap model){
        model.addAttribute("testRequestScope","hello,ModelMap");
        return "sucess";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> model){
        model.put("testRequestScope","hello,Map");
        return "sucess";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessiontScope","hello,Session");

        return "sucess";
    }

    @RequestMapping("/test/application")
    public String testApplivation(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,Application");
        return "sucess";
    }


}
