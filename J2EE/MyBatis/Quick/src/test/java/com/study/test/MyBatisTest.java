package com.study.test;

import com.study.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 周
 * @title MyBatisTest
 * @date 2020/6/28 22:57
 * @description 测试类
 * 测试MyBatis
 */
public class MyBatisTest {

    @Test
    public void testAdd() throws IOException {
        // 模拟User对象
        User u = new User();
        u.setUname("zhaoliu");
        u.setPassword("000");

        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作
        int res = sqlSession.insert("userMapper.add", u);
        System.out.println(res);
        // 事务提交
        sqlSession.commit(res > 0);
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作
        int res = sqlSession.delete("userMapper.delete", 6);
        System.out.println(res);
        // 事务提交
        sqlSession.commit(res > 0);
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 模拟User对象
        User u = new User();
        u.setUid(3);
        u.setUname("wangwu333");
        u.setPassword("333");

        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作
        int res = sqlSession.update("userMapper.update", u);
        System.out.println(res);
        // 事务提交
        sqlSession.commit(res > 0);
        // 释放资源
        sqlSession.close();
    }


    @Test
    public void testQuery() throws IOException {
        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作
        List<User> userList = sqlSession.selectList("userMapper.query");
        System.out.println(userList);
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindById() throws IOException {
        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作
        User user = sqlSession.selectOne("userMapper.findById", 2);
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }
}
