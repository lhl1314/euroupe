package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:8:42
 */
@Entity
@Table(name = "import_export")
public class ImportExportEntity {
    private Integer id;
    private Integer importChina;//进口中国
    private Integer exportItaly;//出口意大利
    private CompanyEntity importExportCompany;
    private String projectFund;//项目资金
    private String investmentRatio;//投资比例
    private String techSpec;//技术和专利
    private String factoryArea;//工厂面积
    private Timestamp createTime;


    public ImportExportEntity() {
    }

    public ImportExportEntity(Integer id, Integer importChina, Integer exportItaly, CompanyEntity importExportCompany, String projectFund, String investmentRatio, String techSpec, String factoryArea, Timestamp createTime) {

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
    @Column(name = "import_China")
    public Integer getImportChina() {
        return importChina;
    }

    public void setImportChina(Integer importChina) {
        this.importChina = importChina;
    }
    @Basic
    @Column(name = "export_italy")
    public Integer getExportItaly() {
        return exportItaly;
    }

    public void setExportItaly(Integer exportItaly) {
        this.exportItaly = exportItaly;
    }
    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public CompanyEntity getImportExportCompany() {
        return importExportCompany;
    }

    public void setImportExportCompany(CompanyEntity importExportCompany) {
        this.importExportCompany = importExportCompany;
    }

    @Basic
    @Column(name = "project_fund")
    public String getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(String projectFund) {
        this.projectFund = projectFund;
    }

    @Basic
    @Column(name = "investment_ratio")
    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }

    @Basic
    @Column(name = "tech_spec")
    public String getTechSpec() {
        return techSpec;
    }

    public void setTechSpec(String techSpec) {
        this.techSpec = techSpec;
    }
    @Basic
    @Column(name = "factory_area")
    public String getFactoryArea() {
        return factoryArea;
    }

    public void setFactoryArea(String factoryArea) {
        this.factoryArea = factoryArea;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
