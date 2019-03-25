package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.HelpCenterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:17:04
 */
@Repository
public class HelpCenterDaoImpl implements HelpCenterDao {
    @Autowired
    BaseDao<HelpCenterEntity>baseDao;
    @Transactional
    @Override
    public List<HelpCenterEntity> getHelpCenterBySerialNumber(int titleSerialNumber) {
        String hql="from HelpCenterEntity where title_serial_number=?";
        List<HelpCenterEntity> entities = baseDao.find(hql, new Object[]{titleSerialNumber});
        return entities;
    }

    @Transactional
    @Override
    public void deleteHelpCenter(int id) {
        String hql="from HelpCenterEntity where id=?";
        HelpCenterEntity entity = baseDao.get(hql, new Object[]{id});
        if (entity!=null){
            baseDao.delete(entity);
        }
    }
    @Transactional
    @Override
    public void deleteHelpContentByHeader(int titleSerialNumber) {
        String hql="from HelpCenterEntity where title_serial_number=?";
        List<HelpCenterEntity> entities = baseDao.find(hql, new Object[]{titleSerialNumber});
        if (entities!=null&&!entities.isEmpty()){
            for (HelpCenterEntity entity:entities){
                baseDao.delete(entity);
            }
        }
    }

    @Transactional
    @Override
    public void saveOrUpdate(HelpCenterEntity helpCenterEntity) {
        baseDao.saveOrUpdate(helpCenterEntity);
    }
}
