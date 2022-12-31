package com.zhouzhou.spring.dao;

/**
 * @author 周万宁
 * @className BookDao
 * @create 2023/1/1-4:32
 * @description
 */
public interface BookDao {
    
    /**
     * @MethodName getPriceByBookId
     * @Author 周万宁
     * @Description 根据图书的ID查询图书的价格
     * @Date 4:40 2023/1/1
     * @Param [bookId]
     * @return java.lang.Integer
     **/
    Integer getPriceByBookId(Integer bookId);
/**
 * @MethodName updateStock
 * @Author 周万宁
 * @Description 更新图书的库存
 * @Date 4:40 2023/1/1
 * @Param [bookId]
 * @return void
 **/
    void updateStock(Integer bookId);

    /**
     * @MethodName updateBalance
     * @Author 周万宁
     * @Description 更新用户余额
     * @Date 4:40 2023/1/1
     * @Param [userId, price]
     * @return void
     **/
    void updateBalance(Integer userId, Integer price);
}
