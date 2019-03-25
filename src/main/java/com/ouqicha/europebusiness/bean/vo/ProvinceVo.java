package com.ouqicha.europebusiness.bean.vo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:17:04
 */
public class ProvinceVo {
    private Integer id;
    private String name;
    private String code;
    private String countryId;

    public ProvinceVo() {
    }

    public ProvinceVo(Integer id, String name, String code, String countryId) {
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "ProvinceVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryId='" + countryId + '\'' +
                '}';
    }
}
