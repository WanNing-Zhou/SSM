package com.zhouzhou.proxy;

import com.zhouzhou.spring.proxy.CalculatorImpl;
import com.zhouzhou.spring.proxy.CalculatorStaticProxy;
import org.junit.Test;

/**
 * @author 周万宁
 * @className ProxyTest
 * @create 2022/12/31-21:22
 * @description
 */
public class ProxyTest {

    @Test
    public void testProxy(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }


}
