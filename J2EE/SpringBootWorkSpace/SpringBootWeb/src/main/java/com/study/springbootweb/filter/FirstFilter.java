package com.study.springbootweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 整合Filter方式一
 */
//@WebFilter(filterName = "FirstFilter", urlPatterns = {"*.do", "*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------in first filter--------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("--------out first filter--------");
    }

    @Override
    public void destroy() {

    }
}
