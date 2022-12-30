package com.zhouzhou.spring.test;

import com.zhouzhou.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周万宁
 * @className LifeCycleTest
 * @create 2022/12/31-4:12
 * @description
 */
public class LifeCycleTest {
    /**
     * 1.实例化
     * 2.依赖注入
     *    后置处理器的postProcessBeforeInitialization方法
     * 3.初始化 需要bean的init-method属性指定初始化方法
     *  后置处理器的postProcessAfterInitialization
     * 4.IOC容器关闭时销毁,通过bean的destory-method属性指定销毁的方法
     *
     * 注意:
     * 若bean的作用域为单例时,生命周期的前三个步骤会在获取IOC时执行
     * 若bean的作用域为多例时,生命周期的前三个步骤会在获取bean时执行
     */
    @Test
    public void test(){
        //ConfigurableApplicationContext是applicationcontext的子接口,其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
        ioc.close();
    }


}
