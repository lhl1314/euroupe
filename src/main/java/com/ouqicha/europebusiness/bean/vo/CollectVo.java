package com.ouqicha.europebusiness.bean.vo;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:07
 */
public class CollectVo {
    private Integer id;
    private Integer accountId;
    private Timestamp timestamp;
    private CompanyVO companyVO;

    private String acId;


    public CollectVo() {
    }


    public CollectVo(Integer id, Integer accountId, Timestamp timestamp, CompanyVO companyVO, String acId) {
        this.id = id;
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.companyVO = companyVO;
        this.acId = acId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }

    public String getAcId() {
        return acId;
    }

    public void setAcId(String acId) {
        this.acId = acId;
    }

    @Override
    public String toString() {
        return "CollectVo{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", timestamp=" + timestamp +
                ", companyVO=" + companyVO +
                ", acId='" + acId + '\'' +
                '}';
    }
}
