package com.study.mapper;

import com.study.domain.Order;

import java.util.List;

/**
 * @author 周
 * @title OrderMapper
 * @date 2020/6/29 16:12
 * @description
 */
public interface OrderMapper {
    List<Order> findAll();
}
