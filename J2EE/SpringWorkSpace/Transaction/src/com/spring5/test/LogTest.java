package com.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 周
 * @title LogTest
 * @date 2020/6/26 9:08
 * @description 测试log4j2
 */
public class LogTest {
    private static final Logger logger= LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.info("HelloWorld");
        logger.warn("Warn");
    }
}
