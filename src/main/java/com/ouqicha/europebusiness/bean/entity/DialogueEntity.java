package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:11:11
 */
@Entity
@Table(name = "dialogue")
public class DialogueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name="send_id")
    private Integer sendId;
    @Column(name = "accept_id")
    private Integer acceptId;
    @Column(name = "connect_id")
    private String connectId;
    @Column(name = "content")
    private String content;
    @Column(name = "send_time")
    private Timestamp sendTime;
    @Column(name = "adminAlsoRead")
    private Integer adminAlsoRead;

    public Integer getAdminAlsoRead() {
        return adminAlsoRead;
    }

    public void setAdminAlsoRead(Integer adminAlsoRead) {
        this.adminAlsoRead = adminAlsoRead;
    }

    public DialogueEntity() {
    }

    public DialogueEntity(Integer sendId, Integer acceptId, String connectId, String content, Timestamp sendTime) {
        this.sendId = sendId;
        this.acceptId = acceptId;
        this.connectId = connectId;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}
