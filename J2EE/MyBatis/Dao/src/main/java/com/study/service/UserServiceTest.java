package com.study.service;

import com.study.dao.UserMapper;
import com.study.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 周
 * @title UserService
 * @date 2020/6/29 12:45
 * @description
 */
public class UserServiceTest {

    private static final Logger logger = Logger.getLogger(UserServiceTest.class);

    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> res = mapper.findAll();
        System.out.println(res);

        User user = mapper.findById(1);
        System.out.println(user);
    }
}
