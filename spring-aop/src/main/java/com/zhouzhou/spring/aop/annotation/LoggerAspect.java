package com.zhouzhou.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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
 * @After :后置通知,在目标对象方法的finally子句中执行的
 * @AfterReturning:返回通知,在目标返回值之后执行
 * @AfterThrowing:异常通知,在目标方法的catch子句中执行
 *
 *
 *
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


    @Pointcut("execution(* com.zhouzhou.spring.aop.annotation.CalculatorImpl.*(..))")
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

        System.out.println("LoggerAspect,后置通知,方法"+signature.getName()+"执行完毕");
    }

    //在返回通知中若要获取目标对象方法的返回值,
    // 只需要通过@AfterReturning注解的returning属性
    //就可以将同时方法的某个参数指定为接收目标对象方法的返回值的参数
    @AfterReturning(value="pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){

        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();


        System.out.println("LoggerAspect,返回通知,方法"+signature.getName()+"结果"+result);

    }


    //在异常通知中若要获取目标对象方法的异常,
    // 只需要通过@AfterReturning注解的rthrowing属性
    //就可以将同时方法的某个参数指定为接收目标对象方法异常的参数
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("LoggerAspect,异常通知,方法"+signature.getName()+"异常"+ex);

    }


    //环绕通知的方法一定要和目标对象方法的返回值一致
    @Around("pointCut()")
    public Object arroundAdviceMethod(ProceedingJoinPoint joinPoint){

        Object result = null;
        try {

            System.out.println("环绕通知--->前置通知");
            //表示目标对象方法的执行
             result= joinPoint.proceed();
            System.out.println("环绕通知--->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知--->异常通知");
        } finally {
            System.out.println("环绕通知--->后置通知");
        }

        return result;
    }



}
