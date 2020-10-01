package com.study.springbootweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 整合Servlet方式二
 */
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------in Second filter--------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--------out Second filter--------");
    }

    @Override
    public void destroy() {

    }

}
