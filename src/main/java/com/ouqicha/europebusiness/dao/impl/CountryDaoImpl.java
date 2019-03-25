package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CountryEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:44
 */
@Repository
public class CountryDaoImpl implements CountryDao {
    @Autowired
    BaseDao<CountryEntity>baseDao;
    @Transactional
    @Override
    public List<CountryEntity> getAll() {
        String hql="from CountryEntity";
        return baseDao.find(hql);
    }


    @Transactional
    @Override
    public List<CountryEntity> getCountrysByPage(int pageNum, int pageSize) {
        String hql="from CountryEntity";
        return baseDao.find(hql,new Object[]{},pageNum,pageSize);
    }
}
