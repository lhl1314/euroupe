package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:17:19
 */
@Entity
@Table(name = "help_center_header")
public class HelpCenterHeaderEntity {


    private Integer id;

    private String helpCenterHeaderName;

    private Timestamp createTime;


    private List<HelpCenterEntity>helpCenterEntities;

    public HelpCenterHeaderEntity() {
    }

    public HelpCenterHeaderEntity(Integer id, String helpCenterHeaderName, Timestamp createTime) {
        this.id = id;
        this.helpCenterHeaderName = helpCenterHeaderName;
        this.createTime = createTime;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "help_center_header_name")
    public String getHelpCenterHeaderName() {
        return helpCenterHeaderName;
    }

    public void setHelpCenterHeaderName(String helpCenterHeaderName) {
        this.helpCenterHeaderName = helpCenterHeaderName;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    @OneToMany(mappedBy = "helpCenterHeaderEntity",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public List<HelpCenterEntity> getHelpCenterEntities() {
        return helpCenterEntities;
    }

    public void setHelpCenterEntities(List<HelpCenterEntity> helpCenterEntities) {
        this.helpCenterEntities = helpCenterEntities;
    }
}
