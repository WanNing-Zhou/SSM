package com.zhouzhou.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 周万宁
 * @className MyBeanPostProcessor
 * @create 2022/12/31-4:26
 * @description
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor----->后置处理器postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的申明周期初始化之后执行
        System.out.println("MyBeanPostProcessor----->后置处理器postProcessAfterInitialization");

        return bean;
    }
}
