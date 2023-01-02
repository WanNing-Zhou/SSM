package com.zhouzhou.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 周万宁
 * @className FirstInterceptor
 * @create 2023/1/3-2:03
 * @description
 * 拦截器的三个方法
 * preHandel():在控制器方法执行之前执行,其返回值表示对控制器方法的拦截(false)或执行(true)
 * preHandel():在控制器方法执行之后执行,
 * agterCompletion():在控制器方法执行之后,且渲染视图执行之后执行
 *
 * 多个拦截器的执行顺序和在SpringMVC配置文件中配置的顺序有关
 * preHandle()按照配置的顺序执行,而postHandle()和afterCompletion()会按照配置的反序执行
 *
 */

@Component
public class SecondInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //preHandle在控制器方法之前执行
        System.out.println("SecondInterceptor-->postHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SecondInterceptor-->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("SecondInterceptor-->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
