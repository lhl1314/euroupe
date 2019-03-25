package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:13:19
 */
@Entity
@Table(name = "prefecture")
public class PrefectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "city_id")
    private Integer cityId;

    public PrefectureEntity() {
    }

    public PrefectureEntity(Integer id, String name, String code, Integer cityId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cityId = cityId;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Prefecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
