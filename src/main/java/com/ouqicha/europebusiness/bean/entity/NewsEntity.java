package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:07
 */
@Entity
@Table(name = "news")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="new_logo")
    private String newLogo;
    @Column(name="content")
    private String content;
    @Column(name="category")
    private String category;
    @Column(name="publish_time")
    private Timestamp publishTime;
    @Column(name="update_time")
    private Timestamp updateTime;
    @Column(name="is_delete")
    private Integer isDelete;


    public NewsEntity() {
    }

    public NewsEntity(Integer id, String title, String author, String newLogo, String content, String category, Timestamp publishTime, Timestamp updateTime, Integer isDelete) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.newLogo = newLogo;
        this.content = content;
        this.category = category;
        this.publishTime = publishTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNewLogo() {
        return newLogo;
    }

    public void setNewLogo(String newLogo) {
        this.newLogo = newLogo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
