package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.ProvinceEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.ProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:45
 */
@Repository
public class ProvinceDaoImpl implements ProvinceDao {
    @Autowired
    BaseDao<ProvinceEntity>baseDao;
    @Transactional
    @Override
    public List<ProvinceEntity> getProvinceList(int countryId) {
        String hql="from ProvinceEntity where country_id=?";
        return baseDao.find(hql,new Object[]{countryId});
    }

    @Transactional
    @Override
    public List<ProvinceEntity> getProvinceListPage(int countryId, int pageNum, int pageSize) {
        String hql="from ProvinceEntity where country_id="+countryId;
        return baseDao.find(hql,new Object[]{},pageNum,pageSize);
    }
}
