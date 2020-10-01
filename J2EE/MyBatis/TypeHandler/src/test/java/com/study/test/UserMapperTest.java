package com.study.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.domain.User;
import com.study.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 周
 * @title UserTest
 * @date 2020/6/29 14:48
 * @description
 */
public class UserMapperTest {
    private final static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testSave() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象，设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 模拟User数据
        User user = new User();
        user.setUname("tom");
        user.setPassword("222");
        user.setBirthday(new Date());
        mapper.save(user);
    }

    @Test
    public void testFindById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象，设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User res = mapper.findById(7);
        logger.debug(res);
    }

    @Test
    public void testFindAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession会话对象，设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页相关参数
        PageHelper.startPage(1, 2);

        List<User> res = mapper.findAll();

        logger.debug(res);
        // 获取与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(res);
        logger.debug("当前页：" + pageInfo.getPageNum());
        logger.debug("总页数：" + pageInfo.getPages());
        logger.debug("总条数：" + pageInfo.getTotal());
        logger.debug("每页显示的数量：" + pageInfo.getPageSize());
        logger.debug("上一页：" + pageInfo.getPrePage());
        logger.debug("下一页：" + pageInfo.getNextPage());
        logger.debug("是否是首页：" + pageInfo.isIsFirstPage());
        logger.debug("是否是尾页：" + pageInfo.isIsLastPage());

    }
}
