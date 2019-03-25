package com.ouqicha.europebusiness.bean.vo;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:11:15
 */
public class DialogueVo {
    private Integer id;
    private Integer sendId;
    private Integer acceptId;
    private String connectId;
    private String content;
    private Timestamp sendTime;

    public DialogueVo() {
    }

    public DialogueVo(Integer id, Integer sendId, Integer acceptId, String connectId, String content, Timestamp sendTime) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DialogueVo{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", acceptId=" + acceptId +
                ", connectId='" + connectId + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
