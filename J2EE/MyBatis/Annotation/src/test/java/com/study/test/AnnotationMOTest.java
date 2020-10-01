package com.study.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 周
 * @title AnnotationTest
 * @date 2020/6/29 20:35
 * @description MyBatis基于注解开发测试
 */
public class AnnotationMOTest {

    public static final Logger logger = Logger.getLogger(AnnotationMOTest.class);
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void testFindUserAndOrderAll() {
        List<User> result = mapper.findUserAndOrderAll();
        logger.debug(result);
    }

}
