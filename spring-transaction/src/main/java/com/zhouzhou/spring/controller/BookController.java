package com.zhouzhou.spring.controller;

import com.zhouzhou.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    public void buyBook(Integer userId,Integer bookId){
        bookService.byBook(userId,bookId);
    }
}
