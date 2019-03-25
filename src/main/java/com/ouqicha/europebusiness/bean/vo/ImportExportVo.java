package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:8:57
 */
public class ImportExportVo {
    private Integer id;
    private Integer importChina;//进口中国
    private Integer exportItaly;//出口意大利

    private String projectFund;//项目资金
    private String investmentRatio;//投资比例
    private String techSpec;//技术和专利
    private String factoryArea;//工厂面积
    private Timestamp createTime;
    private CompanyVO importExportCompany;
    public ImportExportVo() {
    }


    public ImportExportVo(Integer id, Integer importChina, Integer exportItaly, CompanyVO importExportCompany, String projectFund, String investmentRatio, String techSpec, String factoryArea, Timestamp createTime) {
        this.id = id;
        this.importChina = importChina;
        this.exportItaly = exportItaly;
        this.importExportCompany = importExportCompany;
        this.projectFund = projectFund;
        this.investmentRatio = investmentRatio;
        this.techSpec = techSpec;
        this.factoryArea = factoryArea;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImportChina() {
        return importChina;
    }

    public void setImportChina(Integer importChina) {
        this.importChina = importChina;
    }

    public Integer getExportItaly() {
        return exportItaly;
    }

    public void setExportItaly(Integer exportItaly) {
        this.exportItaly = exportItaly;
    }
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public CompanyVO getImportExportCompany() {
        return importExportCompany;
    }

    public void setImportExportCompany(CompanyVO importExportCompany) {
        this.importExportCompany = importExportCompany;
    }

    public String getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(String projectFund) {
        this.projectFund = projectFund;
    }

    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }

    public String getTechSpec() {
        return techSpec;
    }

    public void setTechSpec(String techSpec) {
        this.techSpec = techSpec;
    }

    public String getFactoryArea() {
        return factoryArea;
    }

    public void setFactoryArea(String factoryArea) {
        this.factoryArea = factoryArea;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ImportExportVo{" +
                "id=" + id +
                ", importChina=" + importChina +
                ", exportItaly=" + exportItaly +
                ", importExportCompany=" + importExportCompany +
                ", projectFund='" + projectFund + '\'' +
                ", investmentRatio='" + investmentRatio + '\'' +
                ", techSpec='" + techSpec + '\'' +
                ", factoryArea='" + factoryArea + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
