package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.PrivilegeFunctionEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.PrivilegeFunctionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/14 0014
 * Time:17:20
 */
@Repository
public class PrivilegeFunctionDaoImpl implements PrivilegeFunctionDao {
   @Autowired
    BaseDao<PrivilegeFunctionEntity>baseDao;
   @Transactional
    @Override
    public PrivilegeFunctionEntity getOne(int id) {
        String hql="from PrivilegeFunctionEntity where id=?";
        return baseDao.get(hql,new Object[]{id});
    }
}
