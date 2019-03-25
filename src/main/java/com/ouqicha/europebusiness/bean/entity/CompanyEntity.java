package com.ouqicha.europebusiness.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "company", schema = "europe", catalog = "")
public class CompanyEntity {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String type;
    private String sector1;
    private String sector2;
    private String mainBusiness;
    private String logo;
    private String companyImage;
    private String address;
    private String country;
    private String city;
    private String fax;//'传真',
    private String website;//'网站',
    private String productImage;
    private String description;//'简介',
    private String establishedYear;//'成立年份',
    private String headcount;//'职员数，企业规模',
    private String taxNumber;
    private Timestamp gmtCreate;
    private Timestamp gmtUpdate;
    private Integer isDelete;


    private String keyword;//关键字
    private String turnOver;//营业额
    private String exportTurnover;//'出口营业额度',
    private String bank;//'银行用逗号分开',
    private String paymentMethods;//'付钱方式用逗号分开',
    private String sakesStaff;//'商务人员',
    private String siteStatus;//'公司性质',
    private String vatID;//'税务号码',



    private AccountEntity accountById;
    private PersonEntity peopleById;

    private ImportExportEntity importExportEntity;

    private String companyCategory;



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sector1")
    public String getSector1() {
        return sector1;
    }

    public void setSector1(String sector1) {
        this.sector1 = sector1;
    }

    @Basic
    @Column(name = "sector2")
    public String getSector2() {
        return sector2;
    }

    public void setSector2(String sector2) {
        this.sector2 = sector2;
    }

    @Basic
    @Column(name = "main_business")
    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "company_image")
    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "product_image")
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "company_category")
    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    @Basic
    @Column(name = "established_year")
    public String getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(String establishedYear) {
        this.establishedYear = establishedYear;
    }

    @Basic
    @Column(name = "headcount")
    public String getHeadcount() {
        return headcount;
    }

    public void setHeadcount(String headcount) {
        this.headcount = headcount;
    }

    @Basic
    @Column(name = "tax_number")
    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @JsonIgnore
    @Basic
    @Column(name = "gmt_create")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @JsonIgnore
    @Basic
    @Column(name = "gmt_update")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @JsonIgnore
    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (sector1 != null ? !sector1.equals(that.sector1) : that.sector1 != null) return false;
        if (sector2 != null ? !sector2.equals(that.sector2) : that.sector2 != null) return false;
        if (mainBusiness != null ? !mainBusiness.equals(that.mainBusiness) : that.mainBusiness != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (companyImage != null ? !companyImage.equals(that.companyImage) : that.companyImage != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (productImage != null ? !productImage.equals(that.productImage) : that.productImage != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (establishedYear != null ? !establishedYear.equals(that.establishedYear) : that.establishedYear != null)
            return false;
        if (headcount != null ? !headcount.equals(that.headcount) : that.headcount != null) return false;
        if (taxNumber != null ? !taxNumber.equals(that.taxNumber) : that.taxNumber != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtUpdate != null ? !gmtUpdate.equals(that.gmtUpdate) : that.gmtUpdate != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sector1 != null ? sector1.hashCode() : 0);
        result = 31 * result + (sector2 != null ? sector2.hashCode() : 0);
        result = 31 * result + (mainBusiness != null ? mainBusiness.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (companyImage != null ? companyImage.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (establishedYear != null ? establishedYear.hashCode() : 0);
        result = 31 * result + (headcount != null ? headcount.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtUpdate != null ? gmtUpdate.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }


    @OneToOne(mappedBy = "companyByCompanyId", cascade = CascadeType.ALL)
    public AccountEntity getAccountById() {
        return accountById;
    }

    public void setAccountById(AccountEntity accountById) {
        this.accountById = accountById;
    }


    @OneToOne(mappedBy = "companyByCompanyId", cascade = CascadeType.ALL)
    public PersonEntity getPeopleById() {
        return peopleById;
    }

    public void setPeopleById(PersonEntity peopleById) {
        this.peopleById = peopleById;
    }

    @OneToOne(mappedBy = "importExportCompany", cascade = CascadeType.ALL)
    public ImportExportEntity getImportExportEntity() {
        return importExportEntity;
    }

    public void setImportExportEntity(ImportExportEntity importExportEntity) {
        this.importExportEntity = importExportEntity;
    }


    @Basic
    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "turnover")
    public String getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(String turnOver) {
        this.turnOver = turnOver;
    }

    @Basic
    @Column(name = "export_turnover")
    public String getExportTurnover() {
        return exportTurnover;
    }

    public void setExportTurnover(String exportTurnover) {
        this.exportTurnover = exportTurnover;
    }

    @Basic
    @Column(name = "bank")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "payment_methods")
    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Basic
    @Column(name = "sakes_staff")
    public String getSakesStaff() {
        return sakesStaff;
    }

    public void setSakesStaff(String sakesStaff) {
        this.sakesStaff = sakesStaff;
    }

    @Basic
    @Column(name = "site_status")
    public String getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        this.siteStatus = siteStatus;
    }

    @Basic
    @Column(name = "vatID")
    public String getVatID() {
        return vatID;
    }

    public void setVatID(String vatID) {
        this.vatID = vatID;
    }
}
