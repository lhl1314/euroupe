package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;

/**省级区域
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:9:50
 */
@Entity
@Table(name = "province")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "country_id")
    private Integer countryId;


    public ProvinceEntity() {
    }

    public ProvinceEntity(Integer id, String name, String code, Integer countryId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.countryId = countryId;
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
}
