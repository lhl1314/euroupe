package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:14:52
 */
@Entity
@Table(name = "company_authentication")
public class CompanyAuthenticationEntity {

   private Integer id;

    private String companyName;//公司名称

    private String documentType;//身份证、护照

    private String fullFacePhoto;//正面照片

    private String personalBusinessCart;//个人名片

    private String businessLicense;//营业执照

    private String otherMaterial;//其他材料

    private Timestamp createTime;

    private Integer alsoAuthentication;//已经认证1，未认证0

    private Integer companyId;

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    @Basic
    @Column(name = "document_type")
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    @Basic
    @Column(name = "full_face_phone")
    public String getFullFacePhoto() {
        return fullFacePhoto;
    }

    public void setFullFacePhoto(String fullFacePhoto) {
        this.fullFacePhoto = fullFacePhoto;
    }
    @Basic
    @Column(name = "personal_business_card")
    public String getPersonalBusinessCart() {
        return personalBusinessCart;
    }

    public void setPersonalBusinessCart(String personalBusinessCart) {
        this.personalBusinessCart = personalBusinessCart;
    }
    @Basic
    @Column(name = "business_license")
    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }
    @Basic
    @Column(name = "other_material")
    public String getOtherMaterial() {
        return otherMaterial;
    }

    public void setOtherMaterial(String otherMaterial) {
        this.otherMaterial = otherMaterial;
    }
    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    @Basic
    @Column(name = "also_authentication")
    public Integer getAlsoAuthentication() {
        return alsoAuthentication;
    }

    public void setAlsoAuthentication(Integer alsoAuthentication) {
        this.alsoAuthentication = alsoAuthentication;
    }

}
