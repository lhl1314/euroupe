package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.RolePermissionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;


public class PermissionVO implements Serializable {
    private static final long serialVersionUID = -3028709007211088797L;
    private int id;
    private String permissionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "PermissionVO{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
