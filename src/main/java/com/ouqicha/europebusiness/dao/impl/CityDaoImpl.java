package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CityEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:47
 */
@Repository
public class CityDaoImpl implements CityDao {
    @Autowired
    BaseDao<CityEntity>baseDao;
    @Transactional
    @Override
    public List<CityEntity> getAllCity(int provinceId) {
        String hql="from CityEntity where state_id=?";
        return baseDao.find(hql,new Object[]{provinceId});
    }

    @Transactional
    @Override
    public List<CityEntity> getCityByPage(int provinceId, int pageNum, int pageSize) {
        String hql="from CityEntity where state_id="+provinceId;
        return baseDao.find(hql,new Object[]{},pageNum,pageSize);
    }
}
