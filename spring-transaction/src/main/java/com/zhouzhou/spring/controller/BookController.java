package com.zhouzhou.spring.controller;

import com.zhouzhou.spring.service.BookService;
import com.zhouzhou.spring.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 周万宁
 * @className BookController
 * @create 2023/1/1-4:30
 * @description
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckService checkService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.byBook(userId,bookId);
    }


    public void  checkout(Integer userId,Integer[] bookIds){
        checkService.buyBook(userId,bookIds);
    }

}
