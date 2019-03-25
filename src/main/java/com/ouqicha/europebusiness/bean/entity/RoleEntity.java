package com.ouqicha.europebusiness.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "europe", catalog = "")
public class
RoleEntity {
    private int id;
    private String roleName;
    private Timestamp gmtCreate;
    private Timestamp gmtUpdate;
    private Integer isDelete;
    private Collection<AccountRoleEntity> accountRolesById;
    private Collection<RolePermissionEntity> rolePermissionsById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "gmt_create")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_update")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtUpdate != null ? !gmtUpdate.equals(that.gmtUpdate) : that.gmtUpdate != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtUpdate != null ? gmtUpdate.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
    @JSONField(serialize = false)
    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<AccountRoleEntity> getAccountRolesById() {
        return accountRolesById;
    }

    public void setAccountRolesById(Collection<AccountRoleEntity> accountRolesById) {
        this.accountRolesById = accountRolesById;
    }

    @OneToMany(mappedBy = "roleByRoleId", fetch=FetchType.EAGER)
    public Collection<RolePermissionEntity> getRolePermissionsById() {
        return rolePermissionsById;
    }

    public void setRolePermissionsById(Collection<RolePermissionEntity> rolePermissionsById) {
        this.rolePermissionsById = rolePermissionsById;
    }
}
