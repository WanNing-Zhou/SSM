package com.zhouzhou.spring.test;

import com.zhouzhou.spring.aop.annotation.Calculator;
import com.zhouzhou.spring.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周万宁
 * @className AOPTest
 * @create 2023/1/1-1:04
 * @description
 */
public class AOPTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        int res = calculator.add(1, 1);
        System.out.println(res);

    }



}
