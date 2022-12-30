package com.zhouzhou.spring.test;

import com.zhouzhou.spring.pojo.Clazz;
import com.zhouzhou.spring.pojo.Person;
import com.zhouzhou.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周万宁
 * @className IOCByXMLTest
 * @create 2022/12/31-0:58
 * @description ceshi
 */
public class IOCByXMLTest {

    /**
     * 获取bean的三种方式
     * 1.根据bean的id获取
     * 2.根据bena的类型获取,注意:根据类型获取bean时要求IOC容器中有且只有一个类型匹配bean
     * 若没有任何一个类型匹配的bean此时抛出异常 nosuchbean....
     * 若有多个bean匹配:noUniquebeanD...
     * 3.根据bena的id和类ing来获取
     *总结:
     * 根据类型来获取bean时,在满足bean唯一性的前提下
     * 其实只是看: 对象"instanceof"指定的类型的返回结果
     * 只要返回结果是true就可以衽鼎为和类型匹配,能够获取到
     * 即通过bean的类型,bean所继承的类的类型,bean所实现的接口的类型都可以获取bean
     *
     */

    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        //获取bean
        Student studnetOne = (Student) ioc.getBean("studentOne");
        //
        Student bean = ioc.getBean(Student.class);

        Student studentOne = ioc.getBean("studentOne", Student.class);

        Person bean1 = ioc.getBean(Person.class);
        System.out.println(bean1);

    }

    @Test
    public  void testDI(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student studentTwo = ioc.getBean("studentTwo", Student.class);
        System.out.println(studentTwo);

    }

    @Test
    public  void testDI2(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
//        Student student = ioc.getBean("studentFive", Student.class);
//        System.out.println(student);

        Clazz clazzOne = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazzOne);

    }

}
