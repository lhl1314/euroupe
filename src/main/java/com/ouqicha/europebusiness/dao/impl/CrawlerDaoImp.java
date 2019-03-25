package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.EnuropEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CrawlerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CrawlerDaoImp implements CrawlerDao {

    @Autowired
    private BaseDao<EnuropEntity> baseDao;

//    public BaseDao<EnuropEntity> getBaseDao() {
//        return baseDao;
//    }
//
//    public void setBaseDao(BaseDao<EnuropEntity> baseDao) {
//        this.baseDao = baseDao;
//    }

    @Transactional
    @Override
    public int saveEuropeCompany(EnuropEntity enuropEntity) throws Exception {
        return (Integer) baseDao.save(enuropEntity);
    }
}
