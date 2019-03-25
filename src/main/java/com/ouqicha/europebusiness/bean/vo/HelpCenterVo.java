package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:16:59
 */
public class HelpCenterVo {
    private Integer id;
    private String title;
    private String question;
    private String answer;
    private Timestamp createTime;
    private HelpCenterHeaderVo helpCenterHeaderVo;
    public HelpCenterVo() {
    }

    public HelpCenterVo(Integer id, String title, String question, String answer, Timestamp createTime) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.createTime = createTime;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public HelpCenterHeaderVo getHelpCenterHeaderVo() {
        return helpCenterHeaderVo;
    }

    public void setHelpCenterHeaderVo(HelpCenterHeaderVo helpCenterHeaderVo) {
        this.helpCenterHeaderVo = helpCenterHeaderVo;
    }

    @Override
    public String toString() {
        return "HelpCenterVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", createTime=" + createTime +
                ", helpCenterHeaderVo=" + helpCenterHeaderVo +
                '}';
    }
}
