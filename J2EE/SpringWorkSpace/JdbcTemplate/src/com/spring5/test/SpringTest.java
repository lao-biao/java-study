package com.spring5.test;


import com.spring5.pojo.Book;
import com.spring5.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周
 * @title SpringTest
 * @date 2020/6/20 21:47
 * @description 测试
 */
public class SpringTest {

    ApplicationContext as = new ClassPathXmlApplicationContext("jdbc.xml");
    BookService bs = as.getBean("bookService", BookService.class);

    // 测试添加
    @Test
    public void testJdbcInsert() {
        Book b = new Book(1, "Spring5", "A");
        bs.addBookService(b);
    }

    // 测试修改
    @Test
    public void testJdbcUpdate() {
        Book b = new Book(1, "Spring5", "S");
        bs.updateBookService(b);
    }

    // 测试删除
    @Test
    public void testJdbcDelete() {
        bs.deleteBookService(2);
    }

    // 测试查询表总记录数
    @Test
    public void testJdbcQueryCount() {
        int res = bs.queryCountService();
        System.out.println(res);
    }

    // 测试查询返回对象
    @Test
    public void testJdbcQueryBook() {
        Book res = bs.queryBookService(1);
        System.out.println(res);
    }

    // 测试查询返回集合
    @Test
    public void testJdbcQueryBookList() {
        List<Book> res = bs.queryBookListService();
        System.out.println(res);
    }

    // 测试批量添加
    @Test
    public void testJdbcBatchAdd() {
        List<Object[]> bookList = new ArrayList<>();
        Object[] o1 = {2, "Java", "B"};
        Object[] o2 = {3, "Python", "C"};
        Object[] o3 = {4, "JS", "D"};
        bookList.add(o1);
        bookList.add(o2);
        bookList.add(o3);
        bs.batchAddService(bookList);
    }

    // 测试批量修改
    @Test
    public void testJdbcBatchUpdate() {
        List<Object[]> bookList = new ArrayList<>();
        // 顺序与sql语句中sql值顺序一致
        Object[] o1 = {"C++", "B", 2};
        Object[] o2 = {"R", "C", 3};
        Object[] o3 = {"HTML", "D", 4};
        bookList.add(o1);
        bookList.add(o2);
        bookList.add(o3);
        bs.batchUpdateService(bookList);
    }

    // 测试批量删除
    @Test
    public void testJdbcBatchDelete() {
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {2};
        Object[] o2 = {3};
        Object[] o3 = {4};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bs.batchDeleteService(list);
    }

}
