package com.zhouzhou.spring.test;

import com.zhouzhou.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周万宁
 * @className FactoryBeanTest
 * @create 2022/12/31-4:43
 * @description
 *
 * factoryBean是一个接口,需要创建一个类来实现该接口
 * 其中有三个方法
 * getObjec():通过一个对象交给IOC容器管理
 * getObjectType():设置所提供对象的类型
 * isSingleton():所提供的对象是否是单例
 *
 * 当把FactoryBean的实现类配置为bean时,会将当前类种getObject()所返回的对象交给IOC容器管理
 *
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-fatory.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
    }
}
