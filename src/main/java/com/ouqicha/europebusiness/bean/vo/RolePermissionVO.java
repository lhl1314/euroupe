package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.PermissionEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "role_permission", schema = "europe", catalog = "")
public class RolePermissionVO implements Serializable {
    private static final long serialVersionUID = 229491051410143968L;
    private int id;

    private PermissionVO permission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PermissionVO getPermission() {
        return permission;
    }

    public void setPermission(PermissionVO permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "RolePermissionVO{" +
                "id=" + id +
                ", permission=" + permission +
                '}';
    }
}
