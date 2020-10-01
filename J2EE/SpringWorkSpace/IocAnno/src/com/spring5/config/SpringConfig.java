package com.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周
 * @title SpringConfig
 * @date 2020/6/21 19:32
 * @description 配置类，替代xml配置文件
 */
@Configuration
@ComponentScan(basePackages = {"com.spring5"})
public class SpringConfig {
}
