package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.PrefectureEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.PrefectureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:49
 */
@Repository
public class PrefectureDaoImpl implements PrefectureDao {
    @Autowired
    BaseDao<PrefectureEntity>baseDao;
    @Transactional
    @Override
    public List<PrefectureEntity> getPrefectureList(int cityId) {
        String hql="from PrefectureEntity where city_id=?";
        return baseDao.find(hql,new Object[]{cityId});
    }

    @Transactional
    @Override
    public List<PrefectureEntity> getPrefectureListPage(int cityId, int pageNum, int pageSize) {
        String hql="from PrefectureEntity where city_id="+cityId;
        return baseDao.find(hql,new Object[]{},pageNum,pageSize);
    }
}
