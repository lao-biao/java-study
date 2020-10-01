package com.study.mapper;

import com.study.domain.Order;
import com.study.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 周
 * @title UserMapper
 * @date 2020/6/29 20:45
 * @description
 */
public interface UserMapper {

    @Insert("insert into user_mb values(#{uid},#{uname},#{password},#{birthday})")
    void save(User user);

    @Update("update user_mb set uname=#{uname},password=#{password},birthday=#{birthday} where uid=#{uid}")
    void update(User user);

    @Delete("delete from user_mb where uid=#{uid}")
    void delete(int uid);

    @Select("select * from user_mb where uid=#{uid}")
    User findById(int uid);

    @Select("select * from user_mb")
    List<User> findAll();

    /**
     * 多对一查询
     * @return
     */
    @Select("select * from user_mb")
    @Results({
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "uname", property = "uname"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    column = "uid",
                    property = "orders",
                    javaType = List.class,
                    many = @Many(select = "com.study.mapper.OrderMapper.findById"))
    })
    List<User> findUserAndOrderAll();

    /**
     * 多对多查询
     * @return
     */
    @Select("select * from user_mb")
    @Results({
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "uname", property = "uname"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    column = "uid",
                    property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.study.mapper.RoleMapper.findByUid"))
    })
    List<User> findUserAndRoleAll();

}
