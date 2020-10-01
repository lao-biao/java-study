package com.dao.impl;


import com.dao.UserDao;
import com.pojo.User;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周
 * @title LoginDaoImpl
 * @date 2020/6/14 10:33
 * @description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        // 生成jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 声明数据存储对象
        User user = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "root");
            // 创建sql命令
            String sql = "select * from t_user where uname=? and pwd=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            // 执行
            rs = ps.executeQuery();
            // 遍历执行结构
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            // 返回
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User checkUidDao(String uid) {
        // 生成jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 声明数据存储对象
        User user = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "123456");
            // 创建sql命令
            String sql = "select * from t_user where uid=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, uid);
            // 执行
            rs = ps.executeQuery();
            // 遍历执行结构
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            // 返回
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    // 根据用户ID修改用户密码
    @Override
    public int userChangePwdDao(String newPwd, int uid) {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        // 创建变量
        int index = -1;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "123456");
            // 创建sql命令
            String sql = "update t_user set pwd=? where uid=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, newPwd);
            ps.setInt(2, uid);
            // 执行
            index = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 返回结果
        return index;
    }

    // 获取所有的用户信息
    @Override
    public List<User> userShowDao() {
        // 生成jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 声明数据存储对象
        List<User> lu = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "123456");
            // 创建sql命令
            String sql = "select * from t_user";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 执行
            rs = ps.executeQuery();
            // 给集合赋值
            lu = new ArrayList<>();
            // 遍历执行结构
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth").toString());
                // 将对象存储到集合中
                lu.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return lu;
    }

    // 用户注册
    @Override
    public int userRegDao(User u) {
        // jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        // 声明变量
        int index = -1;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","123456");
            // 创建sql命令
            String sql="insert into t_user values(default,?,?,?,?,?)";
            // 创建sql命令对象
            ps=conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,u.getUname());
            ps.setString(2,u.getPwd());
            ps.setString(3,u.getSex());
            ps.setInt(4,u.getAge());
            ps.setString(5, u.getBirth());
            // 执行
            index=ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 返回结果
        return index;
    }
}
