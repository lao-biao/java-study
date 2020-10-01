package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;

import java.sql.*;

/**
 * @author 周
 * @title UserDaoImpl
 * @date 2020/6/18 16:30
 * @description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserInfoDao(String name) {
        // 声明存储对象
        User u=new User();
        try{
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","123456");
            // 创建sql命令
            String sql="select * from t_users where uname=?";
            // 创建sql命令对象
            PreparedStatement ps=conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,name);
            // 遍历查询
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPrice(rs.getDouble("price"));
                u.setLocation(rs.getString("location"));
                u.setDescription(rs.getString("description"));
            }
            // 关闭资源
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
