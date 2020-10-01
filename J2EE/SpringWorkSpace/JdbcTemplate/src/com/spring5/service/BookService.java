package com.spring5.service;

import com.spring5.dao.BookDao;
import com.spring5.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周
 * @title BookService
 * @date 2020/6/25 14:50
 * @description
 */
@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bd;

    /**
     * 添加
     *
     * @param book
     */
    public void addBookService(Book book) {
        bd.addDao(book);
    }

    /**
     * 修改
     *
     * @param book
     */
    public void updateBookService(Book book) {
        bd.updateDao(book);
    }

    /**
     * 删除
     *
     * @param uid
     */
    public void deleteBookService(int uid) {
        bd.deleteDao(uid);
    }

    /**
     * 查询表总记录数
     *
     * @return
     */
    public int queryCountService() {
        return bd.queryCountDao();
    }

    /**
     * 查询返回对象
     *
     * @return
     */
    public Book queryBookService(int uid) {
        return bd.queryBookDao(uid);
    }

    /**
     * 查询返回集合
     *
     * @return
     */
    public List<Book> queryBookListService() {
        return bd.queryBookListDao();
    }

    /**
     * 批量添加
     */
    public void batchAddService(List<Object[]> batchArgs) {
        bd.batchAddDao(batchArgs);
    }

    /**
     * 批量添加
     */
    public void batchUpdateService(List<Object[]> batchArgs) {
        bd.batchUpdateDao(batchArgs);
    }

    /**
     * 批量删除
     * @param batchArgs
     */
    public void batchDeleteService(List<Object[]> batchArgs){
        bd.batchDeleteDao(batchArgs);
    }
}
