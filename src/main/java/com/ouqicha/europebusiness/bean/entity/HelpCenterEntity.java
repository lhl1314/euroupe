package com.ouqicha.europebusiness.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:16:58
 */
@Entity
@Table(name = "help_center")
public class HelpCenterEntity {

    private Integer id;


    private String title;


    private String question;

    private String answer;

    private Timestamp createTime;
    private HelpCenterHeaderEntity helpCenterHeaderEntity;
    public HelpCenterEntity() {
    }

    public HelpCenterEntity(Integer id, String title, String question, String answer, Timestamp createTime) {

        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.createTime = createTime;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @JSONField(serialize = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_serial_number", referencedColumnName = "id")
    public HelpCenterHeaderEntity getHelpCenterHeaderEntity() {
        return helpCenterHeaderEntity;
    }

    public void setHelpCenterHeaderEntity(HelpCenterHeaderEntity helpCenterHeaderEntity) {
        this.helpCenterHeaderEntity = helpCenterHeaderEntity;
    }
}
