package com.ouqicha.europebusiness.bean.vo;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:16:43
 */
public class AdviceVo {
    private Integer id;
    private Integer accountId;
    private String adviceContent;
    private Timestamp adviceTime;

    private AccountVO accountVO;

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public AdviceVo() {
    }

    public AdviceVo(Integer id, Integer accountId, String adviceContent, Timestamp adviceTime) {
        this.id = id;
        this.accountId = accountId;
        this.adviceContent = adviceContent;
        this.adviceTime = adviceTime;
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

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    public Timestamp getAdviceTime() {
        return adviceTime;
    }

    public void setAdviceTime(Timestamp adviceTime) {
        this.adviceTime = adviceTime;
    }

    @Override
    public String toString() {
        return "AdviceVo{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", adviceContent='" + adviceContent + '\'' +
                ", adviceTime=" + adviceTime +
                '}';
    }
}
