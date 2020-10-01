package com.web.servlet;

import com.pojo.Address;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题:
 * Servlet进行请求处理后，使用作用域对象作为数据流转的载体，将数据流转给对应的jsp文件
 * 在jsp中获取作用域中的数据
 * 使用:
 * 传统方式:在jsp页面中使用java脚本段语句
 */
@WebServlet(name = "ElServlet", urlPatterns = {"/es"})
public class ElServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        // 处理请求信息
        System.out.println(uname + "===" + pwd);
        // 响应处理结果
        // 使用request作用域进行数据流转
        // 普通字符串
        req.setAttribute("str", "今天天气很好!");
        // 对象类型
        User u = new User(0, "张三", "跑步", new Address("湖北", "黄冈", "红安县"));
        req.setAttribute("user", u);
        // 集合类型
        // List集合
        // 存储普通字符串
        List<String> list = new ArrayList<>();
        list.add("周润发");
        list.add("刘德华");
        list.add("周星驰");
        req.setAttribute("list", list);
        // 存储对象
        User u2 = new User(1, "李四", "游泳", new Address("湖北", "武汉", "武昌区"));
        List<User> lu = new ArrayList<>();
        lu.add(u);
        lu.add(u2);
        req.setAttribute("lu", lu);
        // Map集合
        // 存储普通字符串
        Map<String, String> map = new HashMap<>();
        map.put("a", "北京");
        map.put("b", "上海");
        map.put("c", "广州");
        map.put("d", "深圳");
        req.setAttribute("map", map);
        // 存储对象
        Map<String, User> mu = new HashMap<>();
        mu.put("a", new User(2, "张家辉", "演戏", new Address("广东省", "广州市", "中山区")));
        req.setAttribute("mu", mu);

        // 空值判断
        req.setAttribute("s0","");
        req.setAttribute("s1",new User());
        req.setAttribute("s2",new ArrayList<>());
        req.setAttribute("s3",new HashMap<>());

        req.getRequestDispatcher("/el.jsp").forward(req, resp);
        return;
    }
}
