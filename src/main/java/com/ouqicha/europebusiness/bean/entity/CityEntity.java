package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:13:16
 */
@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "state_id")
    private Integer stateId;

    public CityEntity() {
    }

    public CityEntity(Integer id, String name, String code, Integer countryId, Integer stateId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.countryId = countryId;
        this.stateId = stateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                '}';
    }
}
