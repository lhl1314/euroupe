package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cls", schema = "exame", catalog = "")
public class ClsEntity {
    private int clsId;
    private String clsName;
    private Collection<UserEntity> usersByClsId;

    @Id
    @Column(name = "cls_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

    @Basic
    @Column(name = "cls_name")
    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsEntity clsEntity = (ClsEntity) o;

        if (clsId != clsEntity.clsId) return false;
        if (clsName != null ? !clsName.equals(clsEntity.clsName) : clsEntity.clsName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clsId;
        result = 31 * result + (clsName != null ? clsName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsByClsId")
    public Collection<UserEntity> getUsersByClsId() {
        return usersByClsId;
    }

    public void setUsersByClsId(Collection<UserEntity> usersByClsId) {
        this.usersByClsId = usersByClsId;
    }
}
