package com.training.day08;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周超
 * @title UserDao
 * @date 2020/7/22 20:19
 * @description jdbc对数据库进行增删改查
 */
public class UserDao {

    public int insert(User user) {
        // 创建jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        int result = -1;
        // 声明数据存储对象
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false", "root", "root");
            // 创建sql命令
            String sql = "insert into tb_user(`id`,`name`,`gender`,`salary`,`birthday`) values(?,?,?,?,?)";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getGender());
            ps.setDouble(4, user.getSalary());
            ps.setDate(5, user.getBirthday());
            // 执行
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        // 返回
        return result;
    }

    public int update(User user) {
        // 创建jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        int result = -1;
        // 声明数据存储对象
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false", "root", "root");
            // 创建sql命令
            String sql = "update tb_user set `name`=?,`gender`=?,`salary`=?,`birthday`=? where `id`=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setDouble(3, user.getSalary());
            ps.setDate(4, user.getBirthday());
            ps.setString(5, user.getId());
            // 执行
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        // 返回
        return result;
    }

    public int delete(String id) {
        // 创建jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        int result = -1;
        // 声明数据存储对象
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false", "root", "root");
            // 创建sql命令
            String sql = "delete from tb_user where `id`=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, id);
            // 执行
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        // 返回
        return result;
    }

    public List<User> selectAll() {
        // 创建jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> result = null;
        // 声明数据存储对象
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false", "root", "root");
            // 创建sql命令
            String sql = "select * from tb_user";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 执行
            rs = ps.executeQuery();
            // 遍历结果集
            result = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setSalary(rs.getDouble("salary"));
                user.setBirthday(rs.getDate("birthday"));
                // 将对象存储到集合中
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        // 返回
        return result;
    }

}
