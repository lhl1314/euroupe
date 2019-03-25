package com.ouqicha.europebusiness.bean.entity;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@FetchProfile(
        name = "account_role",
        fetchOverrides = {
                @FetchProfile.FetchOverride(
                        entity = AccountEntity.class,
                        association = "accountRolesById",
                        mode = FetchMode.JOIN
                )
        }

)
@Table(name = "account", schema = "europe", catalog = "")
public class AccountEntity {
    private int id;
    private String mobile;
    private String email;
    private String type;
    private String password;
    private Timestamp gmtCreate;
    private Timestamp gmtUpdate;
    private Integer isDelete;
    private PersonEntity personByPersonId;
    private CompanyEntity companyByCompanyId;
    private Collection<AccountRoleEntity> accountRolesById;
    private Collection<SessionEntity> sessionEntity;
    private LoginInfoEntity loginInfoEntity;

    /**
     * 新增字段
     */
    private Integer state;


    private Integer vip;
    @Basic
    @Column(name = "vip")
    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        AccountEntity that = (AccountEntity) o;

        if (id != that.id) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.type) : that.password != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtUpdate != null ? !gmtUpdate.equals(that.gmtUpdate) : that.gmtUpdate != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtUpdate != null ? gmtUpdate.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public PersonEntity getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(PersonEntity personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    @OneToOne(fetch = FetchType.EAGER)//修改后，不用懒加载，立即获取关联表数据
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
    //@JSONField(serialize = false)
    @OneToMany(mappedBy = "accountByAccountId", fetch = FetchType.EAGER)
    public Collection<AccountRoleEntity> getAccountRolesById() {
        return accountRolesById;
    }

    public void setAccountRolesById(Collection<AccountRoleEntity> accountRolesById) {
        this.accountRolesById = accountRolesById;
    }


    @OneToMany(mappedBy = "accountEntity", cascade = CascadeType.MERGE)
    public Collection<SessionEntity> getSessionEntity() {
        return sessionEntity;
    }

    public void setSessionEntity(Collection<SessionEntity> sessionEntity) {
        this.sessionEntity = sessionEntity;
    }

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL)
    public LoginInfoEntity getLoginInfoEntity() {
        return loginInfoEntity;
    }

    public void setLoginInfoEntity(LoginInfoEntity loginInfoEntity) {
        this.loginInfoEntity = loginInfoEntity;
    }
}
