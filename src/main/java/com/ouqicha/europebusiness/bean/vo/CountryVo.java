package com.ouqicha.europebusiness.bean.vo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:17:03
 */
public class CountryVo {
    private Integer id;
    private String name;
    private String code;

    public CountryVo() {
    }

    public CountryVo(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    @Override
    public String toString() {
        return "CountryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
