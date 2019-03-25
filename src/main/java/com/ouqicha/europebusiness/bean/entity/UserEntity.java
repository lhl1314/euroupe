package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "exame", catalog = "")
public class UserEntity {
    private int userId;
//    private Integer clsId;
    private String userName;
    private String userNo;
    private String userSex;
    private ClsEntity clsByClsId;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    @Basic
//    @Column(name = "cls_id")
//    public Integer getClsId() {
//        return clsId;
//    }
//
//    public void setClsId(Integer clsId) {
//        this.clsId = clsId;
//    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_no")
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
//        if (clsId != null ? !clsId.equals(that.clsId) : that.clsId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userNo != null ? !userNo.equals(that.userNo) : that.userNo != null) return false;
        if (userSex != null ? !userSex.equals(that.userSex) : that.userSex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
//        result = 31 * result + (clsId != null ? clsId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userNo != null ? userNo.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cls_id", referencedColumnName = "cls_id")
    public ClsEntity getClsByClsId() {
        return clsByClsId;
    }

    public void setClsByClsId(ClsEntity clsByClsId) {
        this.clsByClsId = clsByClsId;
    }
}
