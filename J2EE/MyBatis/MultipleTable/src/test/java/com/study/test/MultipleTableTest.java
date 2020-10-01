package com.study.test;

import com.study.domain.Order;
import com.study.domain.User;
import com.study.mapper.OrderMapper;
import com.study.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 周
 * @title MultipleTableTest
 * @date 2020/6/29 16:44
 * @description 多表查询测试
 */
public class MultipleTableTest {

    private final SqlSession sqlSession;

    public MultipleTableTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象，设置自动提交事务
        sqlSession = sqlSessionFactory.openSession();
    }

    private final static Logger logger = Logger.getLogger(MultipleTableTest.class);

    @Test
    public void testOrderFindAll() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> res = mapper.findAll();
        logger.debug(res);
    }

    @Test
    public void testUserFindAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 用户与订单关系
        List<User> res = mapper.findAll();
        logger.debug(res);
    }

    @Test
    public void testFindUserRole() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 用户与角色关系
        List<User> res = mapper.findUserRole();
        logger.debug(res);
    }

}
