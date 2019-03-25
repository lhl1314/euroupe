package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AdviceEntity;
import com.ouqicha.europebusiness.dao.AdviceDao;
import com.ouqicha.europebusiness.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:16:45
 */
@Repository
public class AdviceDaoImpl implements AdviceDao {
    @Autowired
    BaseDao<AdviceEntity>baseDao;
    @Transactional
    @Override
    public void addAdvice(AdviceEntity adviceEntity) {
        baseDao.saveOrUpdate(adviceEntity);
    }

    @Transactional
    @Override
    public AdviceEntity getOne(int id) {
        String hql="from AdviceEntity where id=?";
        AdviceEntity entity = baseDao.get(hql, new Object[]{id});
        return entity;
    }

    @Transactional
    @Override
    public List<AdviceEntity> getAdvicePage(int pageNum, int pageSize) {
        String hql="from AdviceEntity";
        List<AdviceEntity> list = baseDao.find(hql, new Object[]{}, pageNum, pageSize);
        return list;
    }

    @Transactional
    @Override
    public Long sqlCount() {
        String hql="select count(*) from AdviceEntity";
        Long count = baseDao.count(hql);
        return count;
    }

    @Transactional
    @Override
    public void deleteAdvice(int id) {
        String sql="from AdviceEntity where id=?";
        AdviceEntity entity = baseDao.get(sql, new Object[]{id});
        if (entity!=null){
            baseDao.delete(entity);
        }
    }
}
