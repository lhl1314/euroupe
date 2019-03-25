package com.ouqicha.europebusiness.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.RolePermissionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;


public class
RoleVO implements Serializable {
    private static final long serialVersionUID = -8228271975713823551L;
    private int id;
    private String roleName;

//    private Collection<AccountRoleEntity> accountRolesById;
    private Collection<RolePermissionVO> rolePermissions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<RolePermissionVO> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Collection<RolePermissionVO> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", rolePermissions=" + rolePermissions +
                '}';
    }
}
