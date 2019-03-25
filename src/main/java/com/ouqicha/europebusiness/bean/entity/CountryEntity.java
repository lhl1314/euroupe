package com.ouqicha.europebusiness.bean.entity;
import javax.persistence.*;

/**国家区域
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:9:22
 */
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制主键生成自增
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;


    public CountryEntity() {
    }

    public CountryEntity(Integer id, String name, String code) {
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
}
