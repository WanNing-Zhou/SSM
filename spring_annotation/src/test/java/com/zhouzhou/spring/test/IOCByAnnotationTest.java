package com.zhouzhou.spring.test;

import com.zhouzhou.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author 周万宁
 * @className IOCByAnnotationTest
 * @create 2022/12/31-5:59
 * @description
 *
 * 通过注解+扫描所配置的bean的id为 默认类的小驼峰,即类名的首字母为小写的结果
 * 可以通过标识组件的注解的value属性值设置bean的自定义id
 * @Autowired:实现自动装配功能的注解
 * 1.@Autowired注解能够标识的位置
 * a>标识到成员变量上,此时不需要设置成员变量
 * b>标识在set方法上
 * c>为当前成员变量赋值的有参构造上
 * 2.@Autowired注解的原理
 * a>默认同通过byType的方式,在IOC容器中同故宫类型匹配某个bean为属性赋值
 * b>若有多个类型匹配的bean,此时会自动转换为byName的方式实现自动装配的效果
 * 即:将要赋值的属性的属性名作为bean的id匹配某个bean
 * c>若byType和byName的方式都无法实现自动装配,即IOC容器中有多个类型匹配的bean
 * 且这些bean的id和要赋值的属性和属性名都不一致,此时会抛出异常,nouniquebean....
 * d>此时可以在要赋值的属性上添加一个注解@Qualifier("指定bean的id")
 * 同故宫该注解的value属性值,指定某个bean的id,将这个bean为属性赋值
 */
public class IOCByAnnotationTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
