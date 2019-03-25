package com.ouqicha.europebusiness.bean.vo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person", schema = "europe", catalog = "")
public class PersonVO implements Serializable {
    private static final long serialVersionUID = 7609725784867829359L;
    private int id;
    private String mobile;
    private String email;
    private String sex;
    private String duty;
    private CompanyVO company;
    private String headerImage;
    private String personName;
    public PersonVO() {
    }

    public PersonVO(int id, String mobile, String email, String sex, String duty, CompanyVO company) {
        this.id = id;
        this.mobile = mobile;
        this.email = email;
        this.sex = sex;
        this.duty = duty;
        this.company = company;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public CompanyVO getCompany() {
        return company;
    }

    public void setCompany(CompanyVO company) {
        this.company = company;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", duty='" + duty + '\'' +
                ", company=" + company +
                ", headerImage='" + headerImage + '\'' +
                ", personName='" + personName + '\'' +
                '}';
    }
}
