package com.study.springbootweb.config;

import com.study.springbootweb.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter配置类
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        //bean.addUrlPatterns("*.do", "*.jsp"); //不定项参数，可以不使用 new String[]{}
        bean.addUrlPatterns("/second");
        return bean;
    }
}
