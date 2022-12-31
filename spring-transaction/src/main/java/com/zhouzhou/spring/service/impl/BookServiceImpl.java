package com.zhouzhou.spring.service.impl;

import com.zhouzhou.spring.dao.BookDao;
import com.zhouzhou.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 周万宁
 * @className BookServiceImpl
 * @create 2023/1/1-4:31
 * @description
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
////            readOnly = true
////            timeout = 3
//            //设置不造成回滚的异常
////            noRollbackFor = ArithmeticException.class
////    noRollbackForClassName =  "java.lang.ArithmeticException"
//
//            //默认的隔离级别
////            isolation = Isolation.DEFAULT
//            //标识不敢当前线程上是否已经开启的失去,都要开启新事务
//            propagation = Propagation.REQUIRES_NEW
//
//    )


    public void byBook(Integer userId,Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
//        System.out.println(price);

        //更新图书的库存
        bookDao.updateStock(bookId);
//        System.out.println("更新图书库存");

        //更新用户的余额
        bookDao.updateBalance(userId,price);
//        System.out.println(1/0);
    }
}
