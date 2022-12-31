package com.zhouzhou.spring.service.impl;

import com.zhouzhou.spring.service.BookService;
import com.zhouzhou.spring.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 周万宁
 * @className CheckServiceImpl
 * @create 2023/1/1-5:41
 * @description
 */
@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void buyBook(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds){
            bookService.byBook(userId,bookId);
        }
    }
}
