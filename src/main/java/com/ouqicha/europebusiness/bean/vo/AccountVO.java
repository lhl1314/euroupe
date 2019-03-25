package com.ouqicha.europebusiness.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;


public class AccountVO implements Serializable {
    private static final long serialVersionUID = 4008904644374391242L;
    private int id;
    private String mobile;
    private String email;
    private String type;
    @JSONField(serialize = false)
    private  String password;
//    @JSONField(serialize = false)
    private PersonVO person;
//    @JSONField(serialize = false)
    private CompanyVO company;//json可以返回该数据
    private Collection<AccountRoleVO> accountRoles;
    private String token;
    private Integer deviceType;
    private String deviceInfo;
    private Timestamp lastLoginTime;

    /**
     * 新增字段
     */
    private Integer isDelete;

    private Integer noReadCount;//客服未读信息的数量
    private Integer vip;//vip

    private Integer state;//区分管理员和普通用户的标识
    //100,管理员，1，用户

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    Set<AccountRoleVO> newAccountRoleVoList;

    public Set<AccountRoleVO> getNewAccountRoleVoList() {
        return newAccountRoleVoList;
    }

    public void setNewAccountRoleVoList(Set<AccountRoleVO> newAccountRoleVoList) {
        this.newAccountRoleVoList = newAccountRoleVoList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNoReadCount() {
        return noReadCount;
    }

    public void setNoReadCount(Integer noReadCount) {
        this.noReadCount = noReadCount;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public PersonVO getPerson() {
        return person;
    }

    public void setPerson(PersonVO person) {
        this.person = person;
    }

    public CompanyVO getCompany() {
        return company;
    }

    public void setCompany(CompanyVO company) {
        this.company = company;
    }

    public Collection<AccountRoleVO> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Collection<AccountRoleVO> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountVO vo = (AccountVO) o;
        return id == vo.id &&
                Objects.equals(mobile, vo.mobile) &&
                Objects.equals(email, vo.email) &&
                Objects.equals(type, vo.type) &&
                Objects.equals(password, vo.password) &&
                Objects.equals(person, vo.person) &&
                Objects.equals(company, vo.company) &&
                Objects.equals(accountRoles, vo.accountRoles) &&
                Objects.equals(token, vo.token) &&
                Objects.equals(deviceType, vo.deviceType) &&
                Objects.equals(deviceInfo, vo.deviceInfo) &&
                Objects.equals(lastLoginTime, vo.lastLoginTime) &&
                Objects.equals(isDelete, vo.isDelete) &&
                Objects.equals(noReadCount, vo.noReadCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobile, email, type, password, person, company, accountRoles, token, deviceType, deviceInfo, lastLoginTime, isDelete, noReadCount);
    }


    @Override
    public String toString() {
        return "AccountVO{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", person=" + person +
                ", company=" + company +
                ", accountRoles=" + accountRoles +
                ", token='" + token + '\'' +
                ", deviceType=" + deviceType +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
