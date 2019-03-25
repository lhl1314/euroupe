package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.util.Page;

import java.util.List;

public interface CompanyService {
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows);


    /**
     * 获取企业的分页信息
     *
     * @param pageId
     * @param pageSize
     * @return
     */
    Page<CompanyVO> getCompanyByPage(int pageId, int pageSize);

    /**
     * 添加企业信息
     *
     * @param companyEntity
     */
    void addCompany(CompanyEntity companyEntity);

    /**
     * 修改企业信息
     *
     * @param companyEntity
     */
    void updateCompany(CompanyEntity companyEntity);

    /**
     * 找到公司的详情信息
     *
     * @param id
     * @return
     */
    CompanyVO getCompanyDetail(int id);

    /**
     * 冻结或者解冻该企业
     *
     * @param id
     */
    void freezeOrUnfreezeCompany(int id);
}
