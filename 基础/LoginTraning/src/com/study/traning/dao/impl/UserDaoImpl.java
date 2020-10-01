package com.study.traning.dao.impl;

import com.study.traning.dao.UserDao;
import com.study.traning.pojo.UserEntity;

import java.sql.*;

/**
 * @author 周超
 * @title UserDaoImpl
 * @date 2020/7/24 15:51
 * @description dao层
 */
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity checkUser(String username) {
        UserEntity user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "root");
            // 查询不需要提交事务
            // conn.setAutoCommit(false);
            String sql = "select * from tb_training_user where `username`=?";
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            // 执行
            rs = ps.executeQuery();
            // 获取数据集
            if (rs.next()) {
                user = new UserEntity();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 返回结果
        return user;
    }
}
