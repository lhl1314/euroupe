package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CompanyAuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:17
 */
@Repository
public class CompanyAuthenticationDaoImpl implements CompanyAuthenticationDao {
    @Autowired
    BaseDao<CompanyAuthenticationEntity>baseDao;
    @Transactional
    @Override
    public void saveOrUpdate(CompanyAuthenticationEntity entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public CompanyAuthenticationEntity getOne(int id) {
        String hql="from CompanyAuthenticationEntity where id=?";
        CompanyAuthenticationEntity entity = baseDao.get(hql, new Object[]{id});
        return entity;
    }

    @Transactional
    @Override
    public CompanyAuthenticationEntity getOneByCompanyId(int companyId) {
        String hql="from CompanyAuthenticationEntity where company_id=?";
        return baseDao.get(hql,new Object[]{companyId});
    }

    @Transactional
    @Override
    public List<CompanyAuthenticationEntity> getByPage(int pageNum, int pageSize) {
        String hql="from CompanyAuthenticationEntity";
        List<CompanyAuthenticationEntity> entities = baseDao.find(hql, new Object[]{}, pageNum, pageSize);
        return entities;
    }

    @Transactional
    @Override
    public Long sqlCount() {
        String hql="select count(*) from CompanyAuthenticationEntity";
        Long count = baseDao.count(hql);
        return count;
    }

    @Transactional
    @Override
    public void delteCompanyAuthentication(int id) {
        String hql="from CompanyAuthenticationEntity where id=?";
        CompanyAuthenticationEntity entity = baseDao.get(hql, new Object[]{id});
        if (entity!=null){
            baseDao.delete(entity);
        }
    }
}
