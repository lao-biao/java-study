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
public class AnnotationTest {

    public static final Logger logger = Logger.getLogger(AnnotationTest.class);
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUname("tianqi");
        user.setPassword("222");
        user.setBirthday(new Date());
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUid(8);
        user.setUname("tianqi555");
        user.setPassword("555");
        user.setBirthday(new Date());
        mapper.update(user);
    }

    @Test
    public void testDelete() {
        mapper.delete(8);
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(2);
        logger.debug(user);
    }

    @Test
    public void testFindAll() {
        List<User> result = mapper.findAll();
        logger.debug(result);
    }

}
