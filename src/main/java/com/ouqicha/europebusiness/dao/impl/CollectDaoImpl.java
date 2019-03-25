package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CollectEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CollectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:03
 */
@Repository
public class CollectDaoImpl implements CollectDao {
    @Autowired
    BaseDao<CollectEntity>baseDao;
    @Transactional
    @Override
    public List<CollectEntity> getAll() {
        String hql="from CollectEntity";
        return baseDao.find(hql);
    }

    @Transactional
    @Override
    public List<CollectEntity> getPageCollectEntity(Integer accountId,Integer page, Integer rows) {
         String hql="from CollectEntity where account_id="+accountId;
        return baseDao.find(hql, new Object[]{}, page, rows);
    }

    @Transactional
    @Override
    public void saveOrUpdate(CollectEntity collectEntity) {
        baseDao.saveOrUpdate(collectEntity);
    }
    @Transactional
    @Override
    public void deleteCollectCompany(int id) {
       String hql="from CollectEntity where id=?";
        CollectEntity entity = baseDao.get(hql, new Object[]{id});
        if (entity!=null){
            baseDao.delete(entity);
        }
    }
    @Transactional
    @Override
    public CollectEntity findOnly(String acId) {
        String hql="from CollectEntity where ac_id=?";
        return baseDao.get(hql,new Object[]{acId});
    }


    @Transactional
    @Override
    public Long collectCount(int accountId) {
        String hql="select count(*) from CollectEntity where account_id=?";
        Long count = baseDao.count(hql, new Object[]{accountId});
        return count;
    }
}
