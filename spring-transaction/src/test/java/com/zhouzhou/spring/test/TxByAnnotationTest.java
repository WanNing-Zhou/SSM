package com.zhouzhou.spring.test;

import com.zhouzhou.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 周万宁
 * @className TxByAnnotationTest
 * @create 2023/1/1-4:46
 * @description
 * 声明式事务的配置步骤:
 * 1.在spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 在需要被事务管理的方法上,添加@Transaction注解,该方法就会被事务管理
 *
 * @Transational注解标识的位置
 * 1.标识在方法上
 * 2.标识在类上,则雷总所有的方法都会被事务管理
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
        System.out.println("正在测试");
    }

    @Test
    public void testCheckOut(){
        Integer[] bookIds = {1,2};
        bookController.checkout(1,bookIds);
    }


}
