package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private BaseDao<CompanyEntity> baseDao;
    @Transactional
    @Override
    public List<CompanyEntity> getAllCompanyList() {
        String hql="From CompanyEntity";
        return baseDao.find(hql);
    }

    @Transactional
    @Override
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows) {
        String hql="From CompanyEntity";
        return baseDao.find(hql, new Object[]{}, page, rows);
    }

    @Transactional
    @Override
    public void saveOrUpdateCompany(CompanyEntity companyEntity) {
        baseDao.saveOrUpdate(companyEntity);
    }

    @Transactional
    @Override
    public CompanyEntity findOneById(Integer id) {
        String hql="From CompanyEntity where id=?";
        return baseDao.get(hql, new Object[]{id});
    }

    @Transactional
    @Override
    public void deleteCompany(CompanyEntity companyEntity) {
        baseDao.delete(companyEntity);
    }


    @Transactional
    @Override
    public Long companySqlCount() {
        String hql="select count(*) from CompanyEntity";
        Long count = baseDao.count(hql);
        return count;
    }

    @Transactional
    @Override
    public List<CompanyEntity> findLikeCompany(String msg) {
        String hql="From CompanyEntity as c where c.name like :name ";
        List<CompanyEntity> list = baseDao.findLike(hql, msg);
        return list;
    }


    @Transactional
    @Override
    public CompanyEntity getOne(int id) {
        String hql="from CompanyEntity where id=?";
        return baseDao.get(hql,new Object[]{id});
    }




}
