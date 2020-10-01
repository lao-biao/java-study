package com.web.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet重定向路径总结
 *  相对路径:从当前请求的路径查找资源的路径
 *      相对路径如果Servlet的别名中包含目录，会造成重定向资源查找失败
 *  绝对路径:第一个/表示服务器根目录
 *      /虚拟项目名/资源路径
 *
 * Servlet请求转发
 *  /表示项目根目录
 *  req.getRequestDispatcher("/login.jsp").forward(req,resp);
 */

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    // 声明日志对象
    Logger logger = Logger.getLogger(UserServlet.class);
    // 获取Service层对象
    UserService us = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        // 获取操作符
        String oper = req.getParameter("oper");
        if ("login".equals(oper)) {
            // 调用登录处理方法
            checkUserLogin(req, resp);
        } else if ("out".equals(oper)) {
            // 调用退出功能
            userOut(req, resp);
        } else if ("pwd".equals(oper)) {
            // 调用修改功能
            userChangePwd(req, resp);
        } else if ("show".equals(oper)) {
            // 调用显示所有用户功能
            userShow(req, resp);
        } else if ("reg".equals(oper)) {
            // 调用注册功能
            userReg(req,resp);
        } else {
            logger.debug("没有找到对应的操作符:" + oper);
        }
    }

    /**
     * 用户注册
     * @param req
     * @param resp
     */
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 响应请求
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age").equals("")?0:Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        String[] bs=null;
        if (!birth.equals("")) {
            bs=birth.split("/");
            birth=bs[2]+"-"+bs[0]+"-"+bs[1];
        }
        User u=new User(0,uname,pwd,sex,age,birth);
        // 处理请求信息
        // 调用业务层处理
        int index=us.userRegService(u);
        // 响应请求结果
        if (index>0){
            // 获取session
            HttpSession hs = req.getSession();
            hs.setAttribute("flag",2);
            // 重定向
            resp.sendRedirect("/mg/login.jsp");
            return;
        }
    }

    /**
     * 显示所有的用户信息
     * @param req
     * @param resp
     */
    private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理请求
        // 调用Service
        List<User> lu=us.userShowService();
        if (lu!=null) {
            // 将查询到的用户数据存储到request对象
            req.setAttribute("lu",lu);
            // 请求转发
            req.getRequestDispatcher("/user/showuser.jsp").forward(req,resp);
            return;
        }
    }

    /**
     * 用户修改密码
     *
     * @param req
     * @param resp
     */
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取数据
        String newPwd = req.getParameter("newPwd");
        // 从session中获取用户信息
        User u = (User) req.getSession().getAttribute("user");
        int uid = u.getUid();
        // 处理请求
        // 调用Service处理
        int index = us.userChangePwdService(newPwd, uid);
        if (index > 0) {
            // 获取session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("flag",1);
            // 重定向到登录页面
            resp.sendRedirect("/mg/login.jsp");
        }
    }

    /**
     * 用户退出
     *
     * @param req
     * @param resp
     */
    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取session对象
        HttpSession hs = req.getSession();
        // 强制销毁session
        hs.invalidate();
        // 重定向到登录页面
        resp.sendRedirect("/mg/login.jsp");
    }

    /**
     * 处理登录
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取登录信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        // 处理请求信息
        // 校验
        User u = us.checkLoginService(uname, pwd);
        // 获取session对象
        HttpSession hs = req.getSession();
        if (u != null) {
            // 将用户数据存储到session中
            hs.setAttribute("user", u);
            // 重定向
            resp.sendRedirect("/mg/main/main.jsp");
            return;
        } else {
            // 添加标识符到session中
            hs.setAttribute("flag", 0);
            // 请求转发
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        // 响应处理请求
    }
}