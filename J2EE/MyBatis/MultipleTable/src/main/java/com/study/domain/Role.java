package com.study.domain;

/**
 * @author 周
 * @title Role
 * @date 2020/6/29 17:53
 * @description
 */
public class Role {
    private int rid;
    private String rolename;

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
