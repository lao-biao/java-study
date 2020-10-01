package com.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author 周
 * @title TxConfig
 * @date 2020/6/26 8:04
 * @description 完全注解实现声明式事务管理
 */
@Configuration
@ComponentScan(basePackages = "com.spring5")    // 开启组件扫描
@EnableTransactionManagement(proxyTargetClass = true)    // 开启事务
public class TxConfig {
    // 创建数据库连接池
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/study");
        dds.setUsername("root");
        dds.setPassword("123456");
        return dds;
    }

    // 创建JdbcTemplate对象
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        // 在IOC容器中根据类型找到dataSource
        JdbcTemplate jt = new JdbcTemplate();
        // 注入dataSource
        jt.setDataSource(dataSource);
        return jt;
    }

    // 创建事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(dataSource);
        return dstm;
    }
}
