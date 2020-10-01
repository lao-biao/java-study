package com.study.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周
 * @title UserMapperTest
 * @date 2020/6/29 13:30
 * @description
 */
public class UserMapperTest {

    @Test
    public void testMultiplyParam() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        /*
        // 模拟user条件
        User user = new User();
        user.setUid(1);
        // user.setUname("zhangsan");
        // user.setPassword("123");
        List<User> result = userMapper.findByCondition(user);

        System.out.println(result);
        */

        // 模拟ids条件
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> res = userMapper.findByIds(ids);
        System.out.println(res);
    }
}
