package com.study.springbootweb.config;

import com.study.springbootweb.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Servlet组件注册类
 */
@Configuration
public class ServletConfig {
    /**
     * 完成Servlet组件的注册
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletConfigurationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
