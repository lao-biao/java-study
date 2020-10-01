package com.spring5.dao;

import com.spring5.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author 周
 * @title BookDaoImpl
 * @date 2020/6/25 14:51
 * @description
 */
@Repository
public class BookDaoImpl implements BookDao {

    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jt;

    // 添加方法
    @Override
    public void addDao(Book book) {
        String sql = "insert into t_book values (?,?,?)";
        int res = jt.update(sql, book.getUid(), book.getUname(), book.getUstatus());
        System.out.println(res);
    }

    @Override
    public void updateDao(Book book) {
        String sql = "update t_book set uname=?,ustatus=? where uid=?";
        int res = jt.update(sql, book.getUname(), book.getUstatus(), book.getUid());
        System.out.println(res);
    }

    @Override
    public void deleteDao(int uid) {
        String sql = "delete from t_book where uid=?";
        int res = jt.update(sql, uid);
        System.out.println(res);
    }

    @Override
    public int queryCountDao() {
        String sql = "select count(*) from t_book";
        Integer res = jt.queryForObject(sql, Integer.class);
        return res;
    }

    @Override
    public Book queryBookDao(int uid) {
        String sql = "select * from t_book where uid=?";
        return jt.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), uid);
    }

    @Override
    public List<Book> queryBookListDao() {
        String sql = "select * from t_book";
        return jt.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void batchAddDao(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] res = jt.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(res));
    }

    @Override
    public void batchUpdateDao(List<Object[]> batchArgs) {
        String sql = "update t_book set uname=?,ustatus=? where uid=?";
        int[] res = jt.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(res));
    }

    @Override
    public void batchDeleteDao(List<Object[]> batchArgs) {
        String sql = "delete from t_book where uid=?";
        int[] res = jt.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(res));
    }
}
