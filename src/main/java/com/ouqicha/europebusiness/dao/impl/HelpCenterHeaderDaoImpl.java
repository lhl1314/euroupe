package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.HelpCenterHeaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/16 0016
 * Time:8:46
 */
@Repository
public class HelpCenterHeaderDaoImpl implements HelpCenterHeaderDao {
    @Autowired
    BaseDao<HelpCenterHeaderEntity>baseDao;
    @Transactional
    @Override
    public List<HelpCenterHeaderEntity> getAll() {
        String hql="from HelpCenterHeaderEntity";
        return baseDao.find(hql);
    }

    @Transactional
    @Override
    public List<HelpCenterHeaderEntity> getByPage(int pageNum, int pageSize) {
        String hql="from HelpCenterHeaderEntity";
        List<HelpCenterHeaderEntity> list = baseDao.find(hql, new Object[]{}, pageNum, pageSize);
        return list;
    }

    @Transactional
    @Override
    public Long HelpCount() {
        String hql="select count(*) from HelpCenterHeaderEntity";
        Long aLong = baseDao.count(hql);
        return aLong;
    }

    @Transactional
    @Override
    public void deleteHelpHeaderCenter(int id) {
       String hql="from HelpCenterHeaderEntity where id=?";
        HelpCenterHeaderEntity entity = baseDao.get(hql, new Object[]{id});
       if (entity!=null){
           baseDao.delete(entity);
       }
    }

    @Transactional
    @Override
    public void saveOrUpdata(HelpCenterHeaderEntity entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public HelpCenterHeaderEntity getOne(int id) {
        String hql="from HelpCenterHeaderEntity where id=?";
        return baseDao.get(hql,new Object[]{id});
    }
}
