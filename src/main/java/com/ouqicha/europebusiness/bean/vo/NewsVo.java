package com.ouqicha.europebusiness.bean.vo;


import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:24
 */
public class NewsVo {
    private Integer id;
    private String newsTile;
    private String newsAuthor;
    private String newLogo;
    private String newsContent;
    private String newsCategory;
    private Timestamp publishTime;
    private Timestamp updateTime;
    private Integer isDelete;

    public NewsVo() {
    }

    public NewsVo(Integer id, String newsTile, String newsAuthor, String newLogo, String newsContent, String newsCategory, Timestamp publishTime, Timestamp updateTime, Integer isDelete) {

        this.id = id;
        this.newsTile = newsTile;
        this.newsAuthor = newsAuthor;
        this.newLogo = newLogo;
        this.newsContent = newsContent;
        this.newsCategory = newsCategory;
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

    public String getNewsTile() {
        return newsTile;
    }

    public void setNewsTile(String newsTile) {
        this.newsTile = newsTile;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public String getNewLogo() {
        return newLogo;
    }

    public void setNewLogo(String newLogo) {
        this.newLogo = newLogo;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
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

    @Override
    public String toString() {
        return "NewsVo{" +
                "id=" + id +
                ", newsTile='" + newsTile + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                ", newLogo='" + newLogo + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsCategory='" + newsCategory + '\'' +
                ", publishTime=" + publishTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
