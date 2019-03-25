package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/6 0006
 * Time:13:50
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    BaseDao<PersonEntity>baseDao;
    @Transactional
    @Override
    public void saveOrUpdate(PersonEntity personEntity) {
        baseDao.saveOrUpdate(personEntity);
    }

    @Transactional
    @Override
    public PersonEntity getOne(int id) {
        String hql="from PersonEntity where id=?";
        return baseDao.get(hql,new Object[]{id});
    }
}
