package com.ouqicha.europebusiness.bean.vo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/16 0016
 * Time:8:52
 */
public class HelpCenterHeaderVo {
    private Integer id;
    private String helpCenterHeaderName;
    private Timestamp createTime;

    List<HelpCenterVo>helpCenterVos;
    public HelpCenterHeaderVo() {
    }

    public HelpCenterHeaderVo(Integer id, String helpCenterHeaderName, Timestamp createTime) {
        this.id = id;
        this.helpCenterHeaderName = helpCenterHeaderName;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHelpCenterHeaderName() {
        return helpCenterHeaderName;
    }

    public void setHelpCenterHeaderName(String helpCenterHeaderName) {
        this.helpCenterHeaderName = helpCenterHeaderName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<HelpCenterVo> getHelpCenterVos() {
        return helpCenterVos;
    }

    public void setHelpCenterVos(List<HelpCenterVo> helpCenterVos) {
        this.helpCenterVos = helpCenterVos;
    }

    @Override
    public String toString() {
        return "HelpCenterHeaderVo{" +
                "id=" + id +
                ", helpCenterHeaderName='" + helpCenterHeaderName + '\'' +
                ", createTime=" + createTime +
                ", helpCenterVos=" + helpCenterVos +
                '}';
    }
}
