package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/14 0014
 * Time:17:14
 */
@Entity
@Table(name = "privilege_function")
public class PrivilegeFunctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "privilege_name")
    private String privilegeName;
    @Column(name = "privilege_count")
    private Integer privilegeCount;

    public PrivilegeFunctionEntity() {
    }

    public PrivilegeFunctionEntity(Integer id, String privilegeName, Integer privilegeCount) {
        this.id=id;
        this.privilegeName = privilegeName;
        this.privilegeCount = privilegeCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Integer getPrivilegeCount() {
        return privilegeCount;
    }

    public void setPrivilegeCount(Integer privilegeCount) {
        this.privilegeCount = privilegeCount;
    }
}
