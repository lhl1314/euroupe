package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.service.CompanyService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.PageControl;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private Mapper mapper;

    @Override
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows) {
        return companyDao.getCompanyList(page, rows);
    }

    @Override
    public Page<CompanyVO> getCompanyByPage(int pageId, int pageSize) {
        Long aLong = companyDao.companySqlCount();
        int sqlCount = aLong.intValue();//企业总数
        int pageTotal = (int) Math.ceil(sqlCount / pageSize);//页码总数
        List<CompanyEntity> companyList = companyDao.getCompanyList(pageId, pageSize);
       if (companyList!=null&&!companyList.isEmpty()){
           List<CompanyVO> voList = Utils.setDozerList(mapper, companyList, CompanyVO.class);
           PageControl<CompanyVO> pageControl = new PageControl<>();
           Page<CompanyVO> page = pageControl.setPage(pageId - 1, pageTotal, voList);
           return page;
       }
       return null;
    }

    @Override
    public void addCompany(CompanyEntity companyEntity) {
        companyEntity.setIsDelete(0);
        companyDao.saveOrUpdateCompany(companyEntity);
    }

    @Override
    public void updateCompany(CompanyEntity companyEntity) {
        companyDao.saveOrUpdateCompany(companyEntity);
    }

    @Override
    public CompanyVO getCompanyDetail(int id) {
        CompanyEntity entity = companyDao.findOneById(id);
        CompanyVO vo = mapper.map(entity, CompanyVO.class);
        return vo;
    }

    @Override
    public void freezeOrUnfreezeCompany(int id) {
        CompanyEntity one = companyDao.findOneById(id);
        if (one != null) {
            if (one.getIsDelete() == 1) {
                one.setIsDelete(0);
            } else {
                one.setIsDelete(1);
            }
            companyDao.saveOrUpdateCompany(one);
        }
    }
}
