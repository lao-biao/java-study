package com.study.mapper;

import com.study.domain.Order;
import com.study.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 周
 * @title OrderMapper
 * @date 2020/6/29 21:55
 * @description
 */
public interface OrderMapper {

    @Select("select * from order_mb where uid=#{uid}")
    List<Order> findById(int uid);

    @Select("select * from order_mb")
    @Results(
            {@Result(id = true, column = "oid", property = "oid"),
                    @Result(column = "total", property = "total"),
                    @Result(column = "orderTime", property = "orderTime"),
                    @Result(
                            column = "uid", // 根据该字段去查询user表的数据
                            property = "user", // 要封装的属性名称
                            javaType = User.class, // 要封装的实体类型
                            one = @One(select = "com.study.mapper.UserMapper.findById")
                    )
            }
    )
    List<Order> findAll();

    /*
    @Select("select * from order_mb o,user_mb u where o.uid=u.uid")
    @Results(
            {@Result(column = "oid", property = "oid"),
                    @Result(column = "total", property = "total"),
                    @Result(column = "orderTime", property = "orderTime"),
                    @Result(column = "uid", property = "user.uid"),
                    @Result(column = "uname", property = "user.uname"),
                    @Result(column = "password", property = "user.password"),
                    @Result(column = "birthday", property = "user.birthday")
            }
    )
    List<Order> findAll();
    */
}
