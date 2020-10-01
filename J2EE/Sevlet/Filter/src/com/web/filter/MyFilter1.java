package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器
 *  作用:
 *      对服务器接受的请求资源和响应给浏览器的资源进行管理
 *      保护Servlet
 *  使用:
 *      创建一个实现了Filter接口的普通java类
 *      覆写接口的方法
 *          init()方法:服务器启动即执行，资源初始化
 *          doFilter()方法:拦截请求，在此方法中可以对资源实现管理
 *              注意:需要手动对请求进行放行
 *          destroy()方法:服务器关闭时执行
 *      在web.xml中配置过滤器
 *          <filter>
 *              <filter-name>test</filter-name>
 *              <filter-class>com.web.filter.TestFilter</filter-class>
 *          </filter>
 *          <filter-mapping>
 *              <filter-name>test</filter-name>
 *              <url-pattern>/*</url-pattern>
 *          </filter-mapping>
 *          注意:
 *              url-pattern:/*  表示拦截所有的请求
 *              url-pattern:*.do    表示所有以.do结尾的请求，一般是用来进行模块拦截处理
 *              url-pattern:/ServletUrlPattern    表示拦截指定url的请求，针对某个Servlet的请求拦截，保护Servlet
 *      过滤器生命周期
 *          从服务器启动到服务器关闭
 *      总结
 *          过滤器程序员声明，服务器根据请求中的uri信息调用
 *      执行
 *          浏览器发起请求到服务器，服务器接收到请求后根据URI信息在web.xml中找到对应的过滤器执行doFilter()方法，
 *          该方法对此次请求进行处理后如果符合要求则放行，放行后如果还有符合要求的规律其则继续进行过滤，找到对应的Servlet进行处理。
 *          Servlet对请求处理完毕后，也就是service()方法结束了。还需要继续返回相应的doFilter()方法继续执行。
 *      案例:
 *          统一编码格式设置
 *          session管理
 *          权限管理
 *          资源管理(统一水印，和谐词汇等)
 */
@WebFilter(filterName = "MyFilter1", urlPatterns = {"/*"})
public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter1.init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter1.doFilter()");
        // 设置编码格式
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        // 判断session
        HttpSession hs = ((HttpServletRequest) servletRequest).getSession();
        if (hs.getAttribute("user")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("/filter/login.jsp");
        }else {
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter1.doFilter()--2");
        }

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter1.destroy()");
    }
}
