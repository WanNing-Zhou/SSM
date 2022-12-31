package com.zhouzhou.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 周万宁
 * @className ValidateAspect
 * @create 2023/1/1-2:09
 * @description
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("execution(* com.zhouzhou.spring.aop.xml.CalculatorImpl.*(..))")
    public void beforeMethod(){

    }

}
