package com.zhouzhou.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 周万宁
 * @className LoggerAspect
 * @create 2023/1/1-0:50
 * @description 切面类
 *
 *
 * 在切面中需要指定的注解将方法标识为通知方法
 * @Before:前置通知,在目标对象方法执行之前执行
 *
 * 切入点表达式:设置在标识通知的注解的value属性中
 * "execution(public int com.zhouzhou.spring.aop.annotation.CalculatorImpl.add(int,int))"
 * execution(* com.zhouzhou.spring.aop.annotation.CalculatorImpl.*(..))
 *  第一个*表示任意的访问修饰符和返回值
 *  第二个*表示类中任意的方法
 *  ..表示任意的参数列表
 *  类的地方也可以使用*,表示包下所有的类
 *
 *  重用切入点表达式
 *  //设置一个公共的切入点表达式
 *     @Pointcut("execution(* com.zhouzhou.spring.aop.annotation.CalculatorImpl.*(..)")
 *     public void  pointCut(){}
 *     //使用方式
 *     @After("pointCut()")
 *
 *  3.获取连接点的信息
 *  在通知方法的参数位置,设置JoinPoint类型的参数,就可以获取连接点所对应的方法的信息
 *   //获取连接点所对应方法的签名信息
 *  Signature signature = joinPoint.getSignature();
 *  //获取连接点所对应方法的参数
 *  Object[] args = joinPoint.getArgs();
 *
 *
 *
 *
 */
@Component
@Aspect //将当前组件标识为切面组件
public class LoggerAspect {


    @Pointcut("execution(* com.zhouzhou.spring.aop.annotation.CalculatorImpl.*(..)")
    public void  pointCut(){

    }

    //@Before("execution(public int com.zhouzhou.spring.aop.annotation.CalculatorImpl.add(int,int))")

    @Before("execution(* com.zhouzhou.spring.aop.annotation.CalculatorImpl.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("LoggerAspect,前置通知,方法"+signature.getName()+",参数:"+ Arrays.toString(args));
    }

    @After("pointCut()")
    public  void agterDaviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("LoggerAspect,前置通知,方法"+signature.getName()+",参数:"+ Arrays.toString(args));
    }





}
