package com.zhouzhou.spring.test;

import com.zhouzhou.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周万宁
 * @className AutowireByXMLTest
 * @create 2022/12/31-5:12
 * @description
 */
public class AutowireByXMLTest {
    /**
     * 自动装配:
     * 根据指定的策略,在IOC容器中匹配某个bean来自动为bean中的类类型的属性或接口类型的属性进行赋值
     * 可以通过bean标签中的autowire属性设置自动装配的策略
     * 自动装配的策略:
     * no,default:表示不装配,即bean中的属性不会自动匹配某个bean为属性赋值,此时属性使用默认值
     * byType:根据要赋值的属性的类型,在IOC容器中匹配某个bean,为属性赋值
     *  注意:
     *      a>若通过类型没有找到任何一个类型匹配的bean,此时不装配,属性使用默认值
     *      b>通过类型找到了多个类型匹配的bean,此时会抛出异常:noUniqueBean....
     *      总结:当使用byType实现自动装配式,IOC容器中有且只有一个类型匹配的bean嫩巩固为属性赋值
     * byName:将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean,为属性赋值
     *   注意:
     *      a>若通过属名没有找到任何一个id匹配的bean,此时不装配,属性使用默认值
     *    总结:当类型匹配的bean有多个时,此时可以使用byName实现自动装配
     *
     */

    @Test
    public void testAutowore(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

}
