package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyAuthenticationVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.util.Page;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:26
 */
public interface CompanyAuthenticationService {

    /**
     * 企业认证申请
     * @param entity
     * @return
     */
   ResponseData<String>addCompanyAuthentication(CompanyAuthenticationEntity entity,int companyId);

    /**
     * 获取一个企业的认证信息
     * @param companyId
     * @return
     */
   ResponseData<CompanyAuthenticationVo>getOneCompanyAuthentication(int companyId);


    /**
     * 获取企业认证申请的分页
     * @param pageNum
     * @param pageSize
     * @return
     */
   Page<CompanyAuthenticationVo>getCompanyAuthenticationVoByPage(int pageNum,int pageSize);

    /**
     * 修改一条认证信息
     * @param id
     */
   void updateCompanyAuthentication(int id);

    /**
     * 删除一条认证请求
     * @param id
     */
   void deleteAuthentication(int id);
}
