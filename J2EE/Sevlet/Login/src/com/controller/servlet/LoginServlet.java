package com.controller.servlet;

import com.pojo.User;
import com.service.LoginService;
import com.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 周
 * @title LoginServlet
 * @date 2020/6/14 9:50
 * @description 登录信息处理
 * 请求中文乱码解决
 * 1.使用String进行数据重新编码
 *  uname=new String(uname.getBytes("iso8859-1"), "utf-8");
 * 2.使用公共配置
 * get方式
 *  req.setCharacterEncoding("utf-8");
 *  在tomcat的目录下的conf目录中修改server.xml文件,在Connector标签中增加属性useBodyEncodingForURI="true"
 * post方式
 *  req.setCharacterEncoding("utf-8");
 *
 * Servlet流程总结
 *  1.浏览器发起请求到服务器
 *  2.服务器接收浏览器的请求,进行解析,创建request对象存储请求数据
 *  3.服务器调用对应的Servlet进行请求处理,并将request对象作为实参传递给Servlet的方法
 *  4.Servlet的方法执行进行请求处理
 *      设置请求编码格式
 *      设置响应编码格式
 *      获取请求信息
 *      处理请求信息
 *          创建业务层对象
 *          调用业务层对象的方法
 *      响应结果处理
 *
 *
 * 请求转发
 *  作用:
 *      实现多个Servlet联动操作处理请求,避免代码冗余,让Servlet的职责更加明确
 *  使用:
 *      req.getRequestDispatcher("要转发的地址").forward(req,resp);
 *      地址:相对路径,直接书写Servlet的别名即可
 *  特点:
 *      一次请求,浏览器地址信息不变
 *  注意:
 *      请求转发后直接return结束即可
 *
 *  request对象的作用域
 * 使用:
 *      request.setAttribute(Object name,Object value);
 *      request.getAttribute(Object obj);
 * 作用:
 *      解决了一次请求内的不同Servlet的数据(请求数据+其他数据)共享问题
 * 作用域:
 *      基于请求转发,一次请求中的所有Servlet共享
 * 注意:
 *      使用Request对象进行数据流转,数据只在一次请求内有效
 * 特点:
 *      服务器创建
 *      每次请求都会创建
 *      生命周期为一次请求
 *
 *
 *
 * 重定向
 *  解决表单重复提交的问题，以及当前Servlet为无法处理的请求的问题
 * 使用:
 *      response.sendRedirect("路径")
 *      本地路径为:URI
 *      网络路径为:定向资源的URL信息
 * 特点:
 *      两次请求，两个request对象
 *      浏览器地址信息改变
 * 时机:
 *      如果请求中有表单数据，而数据又比较重要，不能重复提交，建议使用重定向
 *      如果请求被Servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源
 *
 * 解决主页面用户名显示为null问题
 *  原因:因为在用户登录成功后使用重定向显示主界面，两次请求，
 *      而用户的信息在第一次请求中，第二次请求中没有用户数据，所以显示为null
 *
 *  解决:使用session技术
 *
 * 使用ServletContext对象完成网页计数器
 *      在用户登录校验中创建计数器并自增，然后存储到ServletContext对象中
 *      在主页面里取出计数器数据显示给用户
 *
 *
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");

        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");

        // 获取请求信息
        String uname = req.getParameter("uname");
        // uname=new String(uname.getBytes("iso8859-1"), "utf-8");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + "<==>" + pwd);

        // 处理请求
        // 获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User user = ls.checkLoginService(uname, pwd);
        System.out.println(user);
        // System.out.println(user.getUid()+" "+user.getUname()+" "+user.getPwd());
        // 响应处理请求
        if (user != null) {
            // resp.getWriter().write("登录成功!");
            // 创建Cookie信息实现三天免登录
            Cookie c = new Cookie("uid", user.getUid() + "");
            // 设置Cookie的有效期
            c.setMaxAge(3 * 24 * 3600);
            // 设置Cookie的有效路径
            c.setPath("/login/ck");
            resp.addCookie(c);
            // 将数据存储到session对象中
            HttpSession hs = req.getSession();
            hs.setAttribute("user", user);

            // 创建网页计数器
            ServletContext sc = this.getServletContext();
            int num = sc.getAttribute("number") != null ? (int) sc.getAttribute("number") : 0;
            // 存储
            sc.setAttribute("number", ++num);

            // 重定向
            resp.sendRedirect("/login/main");
            return;
        } else {
            // resp.getWriter().write("登录失败!");
            // 使用request对象实现不同Servlet的数据流转
            req.setAttribute("str", "用户名或密码错误");
            // 使用请求转发
            req.getRequestDispatcher("page").forward(req, resp);
            return;
        }
    }
}
