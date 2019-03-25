package com.ouqicha.europebusiness.bean.entity;

import org.apache.james.mime4j.dom.datetime.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:16:40
 */
@Entity
@Table(name = "advice")
public class AdviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "advice_content")
    private String adviceContent;
    @Column(name = "advice_time")
    private Timestamp adviceTime;

    public AdviceEntity() {
    }

    public AdviceEntity(Integer accountId, String adviceContent, Timestamp adviceTime) {
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
        return "AdviceEntity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", adviceContent='" + adviceContent + '\'' +
                ", adviceTime=" + adviceTime +
                '}';
    }
}
