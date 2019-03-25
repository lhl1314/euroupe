package com.ouqicha.europebusiness.bean.vo;

import javax.persistence.Column;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/14 0014
 * Time:17:16
 */
public class PrivilegeFunctionVo {
    private Integer id;
    private String privilegeName;
    private Integer privilegeCount;

    public PrivilegeFunctionVo() {
    }

    public PrivilegeFunctionVo(Integer id, String privilegeName, Integer privilegeCount) {
        this.id = id;
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

    @Override
    public String toString() {
        return "PrivilegeFunctionVo{" +
                "id=" + id +
                ", privilegeName='" + privilegeName + '\'' +
                ", privilegeCount=" + privilegeCount +
                '}';
    }
}
