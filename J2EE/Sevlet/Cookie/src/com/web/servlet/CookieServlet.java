package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周
 * @title CookieServlet
 * @date 2020/6/14 15:49
 * @description Cookie学习
 *
 * 作用:解决发送的不同请求的数据共享问题
 * 使用:
 *  Cookie的创建和存储
 *      创建Cookie对象
 *      Cookie cookie=new Cookie(String name,String value);
 *      设置Cookie(可选)
 *          设置有效期
 *          cookie.setMaxAge(int seconds);
 *          设置有效路径
 *          cookie.setPath(String uri);
 *      响应Cookie信息给客户端
 *      resp.addCookie(cookie);
 *  Cookie的获取
 *      获取Cookie信息数组
 *      Cookie[] cookies=req.getCookies();
 *      遍历数组获取Cookie信息
 *      使用for循环遍历
 *      if(cookies!=null) {
 *          for (Cookie c : cookies) {
 *              String name = c.getName();
 *              String value = c.getValue();
 *              System.out.println(name + ":" + value);
 *          }
 *      }
 *
 * 注意:
 *      一个Cookie对象存储一条数据，多天数据，可以创建多个Cookie对象进行存储
 * 特点:
 *      浏览器端的数据存储奇数
 *      存储的数据声明在服务器端
 *      临时存储:存储在浏览器的运行内存中，浏览器关闭即失效
 *      定时存储:设置了Cookie的有效期，存储在客户端的硬盘中，在有效期内符合路径要求的请求都会附带信息
 *      默认Cookie信息存储好之后，每次请求都会附带，除非设置有效路径
 *
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        // 处理请求信息
        // 响应处理结果
        // 使用Cookie进行浏览器端的数据存储
        Cookie cookie=new Cookie("mouse","thinkpad");
        Cookie cookie2=new Cookie("key","servlet");
        // 设置Cookie
        // 设置有Cookie效期
        cookie2.setMaxAge(3*24*60*60);
        // 设置有效路径
        cookie2.setPath("/cookie/gc");
        // 响应Cookie信息
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        // 直接响应
        resp.getWriter().write("Cookie学习");
        // 请求转发
        // 重定向
    }
}
