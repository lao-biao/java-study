package com.study.mapper;

import com.study.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 周
 * @title RoleMapper
 * @date 2020/6/29 22:52
 * @description
 */
public interface RoleMapper {

    @Select("select * from user_role_mb ur,role_mb r where ur.uid=#{uid} and ur.rid=r.rid")
    List<Role> findByUid(int uid);
}
