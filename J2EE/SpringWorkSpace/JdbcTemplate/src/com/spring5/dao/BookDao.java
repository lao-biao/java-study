package com.spring5.dao;

import com.spring5.pojo.Book;

import java.util.List;

/**
 * @author 周
 * @title BookDao
 * @date 2020/6/25 14:50
 * @description
 */
public interface BookDao {
    // 添加
    void addDao(Book book);

    // 修改
    void updateDao(Book book);

    // 删除
    void deleteDao(int uid);

    // 查询表中总记录数
    int queryCountDao();

    // 查询返回对象
    Book queryBookDao(int uid);

    // 查询返回集合
    List<Book> queryBookListDao();

    // 批量添加
    void batchAddDao(List<Object[]> batchArgs);

    // 批量修改
    void batchUpdateDao(List<Object[]> batchArgs);

    // 批量删除
    void batchDeleteDao(List<Object[]> batchArgs);
}
