package com.zhouzhou.spring.service.impl;

import com.zhouzhou.spring.dao.BookDao;
import com.zhouzhou.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void byBook(Integer userId,Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        System.out.println(price);

        //更新图书的库存
        bookDao.updateStock(bookId);
        System.out.println("更新图书库存");

        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
