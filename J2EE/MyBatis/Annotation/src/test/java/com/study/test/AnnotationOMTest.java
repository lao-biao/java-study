package com.study.test;

import com.study.domain.Order;
import com.study.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 周
 * @title AnnotationOMTest
 * @date 2020/6/29 20:35
 * @description MyBatis基于注解开发测试，测试一对多关系
 */
public class AnnotationOMTest {

    public static final Logger logger = Logger.getLogger(AnnotationOMTest.class);
    private OrderMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void findAll() {
        List<Order> result = mapper.findAll();
        logger.debug(result);
    }
}
