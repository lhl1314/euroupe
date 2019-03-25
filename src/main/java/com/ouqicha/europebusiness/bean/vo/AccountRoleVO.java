package com.ouqicha.europebusiness.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


public class AccountRoleVO implements Serializable {

    private static final long serialVersionUID = -5792084490698377523L;
    private int id;

    private RoleVO role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public RoleVO getRole() {
        return role;
    }

    public void setRole(RoleVO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountRoleVO{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
