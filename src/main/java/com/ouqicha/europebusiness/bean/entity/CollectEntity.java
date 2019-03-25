package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:13:54
 */
@Entity
@Table(name = "collect")
public class CollectEntity {
    private Integer id;

    private Integer accountId;


    private Timestamp timestamp;

    private String acId;
    private CompanyEntity companyEntity;


    public CollectEntity() {
    }

    public CollectEntity(Integer id, Integer accountId, Timestamp timestamp, String acId, CompanyEntity companyEntity) {
        this.id = id;
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.acId = acId;
        this.companyEntity = companyEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "collect_time")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    @Basic
    @Column(name = "account_id")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @OneToOne(fetch = FetchType.EAGER)//修改后，不用懒加载，立即获取关联表数据
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    @Basic
    @Column(name = "ac_id")
    public String getAcId() {
        return acId;
    }

    public void setAcId(String acId) {
        this.acId = acId;
    }
}
