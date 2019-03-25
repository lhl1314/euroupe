package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AdviceEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.*;
import com.ouqicha.europebusiness.dao.CompanyAuthenticationDao;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.CompanyAuthenticationService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.PageControl;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:28
 */
@Service
public class CompanyAuthenticationServiceImpl implements CompanyAuthenticationService {
    @Autowired
    CompanyAuthenticationDao companyAuthenticationDao;
    @Autowired
    Mapper mapper;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public ResponseData<String> addCompanyAuthentication(CompanyAuthenticationEntity entity,int companyId) {
        ResponseData<String>data=new ResponseData<>();
        CompanyEntity one = companyDao.findOneById(companyId);
        if (one!=null){
            entity.setCompanyId(companyId);
            companyAuthenticationDao.saveOrUpdate(entity);

            data.setData(null);
            data.setErrorCode(1);
            data.setErrorMessage("企业认证申请成功");
            return data;
        }else {
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("企业认证申请失败");
            return data;
        }

    }

    @Override
    public ResponseData<CompanyAuthenticationVo> getOneCompanyAuthentication(int companyId) {
        ResponseData<CompanyAuthenticationVo>data=new ResponseData<>();
        CompanyAuthenticationEntity one = companyAuthenticationDao.getOneByCompanyId(companyId);
        if (one!=null){
            data.setData(mapper.map(one,CompanyAuthenticationVo.class));
            data.setErrorCode(1);
            data.setErrorMessage("企业认证信息查找成功");
            return data;
        }
        data.setErrorCode(0);
        data.setErrorMessage("企业认证信息查找失败");
        return data;
    }

    @Override
    public Page<CompanyAuthenticationVo> getCompanyAuthenticationVoByPage(int pageNum, int pageSize) {
        int count = companyAuthenticationDao.sqlCount().intValue();
        int pageTotal = (int) Math.ceil(count / pageSize);//总的页数
        List<CompanyAuthenticationEntity> entityList = companyAuthenticationDao.getByPage(pageNum, pageSize);
        List<CompanyAuthenticationVo> voList = Utils.setDozerList(mapper, entityList, CompanyAuthenticationVo.class);
        for (CompanyAuthenticationVo vo:voList){
            CompanyEntity one = companyDao.getOne(vo.getCompanyId());
            CompanyVO companyVO = mapper.map(one, CompanyVO.class);
            vo.setCompanyVO(companyVO);
        }
        PageControl<CompanyAuthenticationVo> pageControl = new PageControl<>();
        Page<CompanyAuthenticationVo> page = pageControl.setPage(pageNum - 1, pageTotal, voList);
        return page;
    }

    @Override
    public void updateCompanyAuthentication(int id) {
        CompanyAuthenticationEntity entity = companyAuthenticationDao.getOne(id);
        if (entity.getAlsoAuthentication()==0){
            entity.setAlsoAuthentication(1);
        }else {
            entity.setAlsoAuthentication(0);
        }
        companyAuthenticationDao.saveOrUpdate(entity);
    }

    @Override
    public void deleteAuthentication(int id) {
        companyAuthenticationDao.delteCompanyAuthentication(id);
    }
}
