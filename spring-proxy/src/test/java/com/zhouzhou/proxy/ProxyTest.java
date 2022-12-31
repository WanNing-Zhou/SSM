package com.zhouzhou.proxy;

import com.zhouzhou.spring.proxy.Calculator;
import com.zhouzhou.spring.proxy.CalculatorImpl;
import com.zhouzhou.spring.proxy.CalculatorStaticProxy;
import com.zhouzhou.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author 周万宁
 * @className ProxyTest
 * @create 2022/12/31-21:22
 * @description
 */
public class ProxyTest {

    /**
     * 动态代理有两种:
     * 1.jdk动态代理:要求必须有接口,最终生成的代理类和目标类实现相同的接口
     * 最终生成的代理类再com.sun.proxy包下,类名为$proxy2
     * 2.cglib动态代理:最终生成的代理类会继承目标类,并且和目标类在相同的包下
     */
    @Test
    public void testProxy(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }


    @Test
    public void testProxyFatory(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
        proxy.div(1,1);

    }
}
