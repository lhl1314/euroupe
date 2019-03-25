package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import java.util.List;

public interface CompanyDao {
    /**
     * 获取所有的企业信息
     * @return
     */
    List<CompanyEntity>getAllCompanyList();
    /**
     * 类似mysql的limit 语句，需要page分页的包装类进行包装
     * @param page
     * @param rows
     * @return
     */
    List<CompanyEntity> getCompanyList(Integer page, Integer rows);

    /**
     * 添加或者修改一个公司信息
     * @param companyEntity
     */
    void saveOrUpdateCompany(CompanyEntity companyEntity);

    /**
     * 找一个公司的公司详情
     * @param id
     * @return
     */
    CompanyEntity findOneById(Integer id);

    /**
     * 测试删除，实际上更改删除的状态
     * @param companyEntity
     */
    void deleteCompany(CompanyEntity companyEntity);


    /**
     * 企业的总数量
     * @return
     */
    Long companySqlCount();


    /**
     * 模糊查询企业
     * @param msg
     * @return
     */
    List<CompanyEntity>findLikeCompany(String msg);


    /**
     * 获取一条企业信息
     * @param id
     * @return
     */
    CompanyEntity getOne(int id);


    /**
     * 测试一下，获取某公司的进出口信息
     * @param id
     * @return
     */

}
