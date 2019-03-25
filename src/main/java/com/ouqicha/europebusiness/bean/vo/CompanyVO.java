package com.ouqicha.europebusiness.bean.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "company", schema = "europe", catalog = "")
public class CompanyVO implements Serializable {
    private static final long serialVersionUID = 864849986642032023L;
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
    private String fax;
    private String website;
    private String productImage;
    private String description;
    private String establishedYear;
    private String headcount;
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








    private String companyCategory;

    private AccountVO accountVO;
    private PersonVO personVO;


    private ImportExportVo importExportVo;

    private List<String> companyImagesList;
    private List<String> productImagesList;


    public List<String> getCompanyImagesList() {
        return companyImagesList;
    }

    public void setCompanyImagesList(List<String> companyImagesList) {
        this.companyImagesList = companyImagesList;
    }

    public List<String> getProductImagesList() {
        return productImagesList;
    }

    public void setProductImagesList(List<String> productImagesList) {
        this.productImagesList = productImagesList;
    }


    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    public CompanyVO() {
    }

    public CompanyVO(
            int id, String name, String mobile, String email, String type, String sector1, String sector2, String mainBusiness, String logo, String companyImage, String address, String country, String city, String fax, String website, String productImage, String description, String establishedYear, String headcount, String taxNumber, Timestamp gmtCreate, Timestamp gmtUpdate, Integer isDelete, AccountVO accountVO, PersonVO personVO) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.type = type;
        this.sector1 = sector1;
        this.sector2 = sector2;
        this.mainBusiness = mainBusiness;
        this.logo = logo;
        this.companyImage = companyImage;
        this.address = address;
        this.country = country;
        this.city = city;
        this.fax = fax;
        this.website = website;
        this.productImage = productImage;
        this.description = description;
        this.establishedYear = establishedYear;
        this.headcount = headcount;
        this.taxNumber = taxNumber;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
        this.isDelete = isDelete;
        this.accountVO = accountVO;
        this.personVO = personVO;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSector1() {
        return sector1;
    }

    public void setSector1(String sector1) {
        this.sector1 = sector1;
    }

    public String getSector2() {
        return sector2;
    }

    public void setSector2(String sector2) {
        this.sector2 = sector2;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(String establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getHeadcount() {
        return headcount;
    }

    public void setHeadcount(String headcount) {
        this.headcount = headcount;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public PersonVO getPersonVO() {
        return personVO;
    }

    public void setPersonVO(PersonVO personVO) {
        this.personVO = personVO;
    }


    public ImportExportVo getImportExportVo() {
        return importExportVo;
    }

    public void setImportExportVo(ImportExportVo importExportVo) {
        this.importExportVo = importExportVo;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(String turnOver) {
        this.turnOver = turnOver;
    }

    public String getExportTurnover() {
        return exportTurnover;
    }

    public void setExportTurnover(String exportTurnover) {
        this.exportTurnover = exportTurnover;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getSakesStaff() {
        return sakesStaff;
    }

    public void setSakesStaff(String sakesStaff) {
        this.sakesStaff = sakesStaff;
    }

    public String getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getVatID() {
        return vatID;
    }

    public void setVatID(String vatID) {
        this.vatID = vatID;
    }


    @Override
    public String toString() {
        return "CompanyVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", sector1='" + sector1 + '\'' +
                ", sector2='" + sector2 + '\'' +
                ", mainBusiness='" + mainBusiness + '\'' +
                ", logo='" + logo + '\'' +
                ", companyImage='" + companyImage + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", fax='" + fax + '\'' +
                ", website='" + website + '\'' +
                ", productImage='" + productImage + '\'' +
                ", description='" + description + '\'' +
                ", establishedYear='" + establishedYear + '\'' +
                ", headcount='" + headcount + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                ", isDelete=" + isDelete +
                ", keyword='" + keyword + '\'' +
                ", turnOver='" + turnOver + '\'' +
                ", exportTurnover='" + exportTurnover + '\'' +
                ", bank='" + bank + '\'' +
                ", paymentMethods='" + paymentMethods + '\'' +
                ", sakesStaff='" + sakesStaff + '\'' +
                ", siteStatus='" + siteStatus + '\'' +
                ", vatID='" + vatID + '\'' +
                ", companyCategory='" + companyCategory + '\'' +
                ", accountVO=" + accountVO +
                ", personVO=" + personVO +
                ", importExportVo=" + importExportVo +
                ", companyImagesList=" + companyImagesList +
                ", productImagesList=" + productImagesList +
                '}';
    }
}
