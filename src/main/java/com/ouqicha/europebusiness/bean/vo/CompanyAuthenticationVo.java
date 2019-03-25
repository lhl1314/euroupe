package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:11
 */
public class CompanyAuthenticationVo implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String companyName;
    private String documentType;
    private String fullFacePhoto;
    private String personalBusinessCart;
    private String businessLicense;
    private String otherMaterial;
    private Timestamp createTime;
    private Integer companyId;
    private Integer alsoAuthentication;


    private CompanyVO companyVO;

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }

    public CompanyAuthenticationVo() {
    }

    public CompanyAuthenticationVo(Integer id, String companyName, String documentType, String fullFacePhoto, String personalBusinessCart, String businessLicense, String otherMaterial, Timestamp createTime, Integer companyId) {
        this.id = id;
        this.companyName = companyName;
        this.documentType = documentType;
        this.fullFacePhoto = fullFacePhoto;
        this.personalBusinessCart = personalBusinessCart;
        this.businessLicense = businessLicense;
        this.otherMaterial = otherMaterial;
        this.createTime = createTime;
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFullFacePhoto() {
        return fullFacePhoto;
    }

    public void setFullFacePhoto(String fullFacePhoto) {
        this.fullFacePhoto = fullFacePhoto;
    }

    public String getPersonalBusinessCart() {
        return personalBusinessCart;
    }

    public void setPersonalBusinessCart(String personalBusinessCart) {
        this.personalBusinessCart = personalBusinessCart;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getOtherMaterial() {
        return otherMaterial;
    }

    public void setOtherMaterial(String otherMaterial) {
        this.otherMaterial = otherMaterial;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAlsoAuthentication() {
        return alsoAuthentication;
    }

    public void setAlsoAuthentication(Integer alsoAuthentication) {
        this.alsoAuthentication = alsoAuthentication;
    }


    @Override
    public String toString() {
        return "CompanyAuthenticationVo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", fullFacePhoto='" + fullFacePhoto + '\'' +
                ", personalBusinessCart='" + personalBusinessCart + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", otherMaterial='" + otherMaterial + '\'' +
                ", createTime=" + createTime +
                ", companyId=" + companyId +
                ", alsoAuthentication=" + alsoAuthentication +
                '}';
    }
}
