package com.ouqicha.europebusiness.bean.vo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:17:03
 */
public class CityVo {
    private Integer id;
    private String name;
    private String code;
    private Integer countryId;
    private Integer stateId;

    public CityVo() {
    }

    public CityVo(Integer id, String name, String code, Integer countryId, Integer stateId) {
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
        return "CityVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                '}';
    }
}
