package com.ouqicha.europebusiness.bean.vo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:17:04
 */
public class PrefectureVo {
    private Integer id;
    private String name;
    private String code;
    private Integer cityId;


    public PrefectureVo() {
    }

    public PrefectureVo(Integer id, String name, String code, Integer cityId) {
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
        return "PrefectureVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
