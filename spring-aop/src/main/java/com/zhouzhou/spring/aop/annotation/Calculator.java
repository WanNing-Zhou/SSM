package com.zhouzhou.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author 周万宁
 * @className Calculator
 * @create 2022/12/31-20:32
 * @description
 */

public interface Calculator {

    int add(int i, int j);
    int sub(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);

}
