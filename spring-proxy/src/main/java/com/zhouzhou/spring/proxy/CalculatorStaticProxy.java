package com.zhouzhou.spring.proxy;

/**
 * @author 周万宁
 * @className CalculatorStaticProxy
 * @create 2022/12/31-21:14
 * @description
 */
public class CalculatorStaticProxy implements Calculator{

    private Calculator target;

    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {

        System.out.println("日志 方法:add 参数:"+i+","+j);
        int result = target.add(i, j);
        System.out.println("日志 方法:add 结果"+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志 方法:sub 参数:"+i+","+j);
        int result = target.sub(i, j);
        System.out.println("日志 方法:sub 结果"+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志 方法:mul 参数:"+i+","+j);
        int result = target.mul(i, j);
        System.out.println("日志 方法:mul 结果"+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志 方法:div 参数:"+i+","+j);
        int result = target.div(i, j);
        System.out.println("日志 方法:div 结果"+result);
        return result;
    }
}
