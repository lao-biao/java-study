package com.dao.impl;


import com.dao.LoginDao;
import com.pojo.User;

import java.sql.*;

/**
 * @author 周
 * @title LoginDaoImpl
 * @date 2020/6/14 10:33
 * @description
 */
public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        // 生成jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        // 声明数据存储对象
        User user=null;
        try{
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","root");
            // 创建sql命令
            String sql="select * from t_user where uname=? and pwd=?";
            // 创建sql命令对象
            ps=conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            // 执行
            rs=ps.executeQuery();
            // 遍历执行结构
            while (rs.next()){
                user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        // 声明数据存储对象
        User user=null;
        try{
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","root");
            // 创建sql命令
            String sql="select * from t_user where uid=?";
            // 创建sql命令对象
            ps=conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,uid);
            // 执行
            rs=ps.executeQuery();
            // 遍历执行结构
            while (rs.next()){
                user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
}
