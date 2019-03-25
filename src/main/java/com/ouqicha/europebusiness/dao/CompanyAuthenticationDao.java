package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:13
 */
public interface CompanyAuthenticationDao {
    /**
     * 添加一条企业认证信息
     * @param entity
     */
    void saveOrUpdate(CompanyAuthenticationEntity entity);

    /**
     * 获取一条认证信息
     * @param id
     * @return
     */
    CompanyAuthenticationEntity getOne(int id);


    /**
     * 根据企业id获取一条认证信息
     * @param companyId
     * @return
     */
    CompanyAuthenticationEntity getOneByCompanyId(int companyId);


    /**
     * 后台
     */

    /**
     * 分页获取企业的认证申请
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CompanyAuthenticationEntity>getByPage(int pageNum,int pageSize);


    /**
     * 申请的数量
     * @return
     */
    Long sqlCount();

    /**
     * 删除一条认证
     * @param id
     */
    void delteCompanyAuthentication(int id);
}
