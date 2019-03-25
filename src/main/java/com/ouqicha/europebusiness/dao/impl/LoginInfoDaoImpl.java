package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.LoginInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:16:45
 */
@Repository
public class LoginInfoDaoImpl implements LoginInfoDao {
    @Autowired
    BaseDao<LoginInfoEntity> baseDao;

    @Transactional
    @Override
    public LoginInfoEntity findOne(int userId) {
        String hql="from LoginInfoEntity where user_id=?";
        LoginInfoEntity infoEntity = baseDao.get(hql, new Object[]{userId});
        return infoEntity;
    }

    @Override
    public void add(LoginInfoEntity loginInfoEntity) {

    }

    @Override
    public void update(LoginInfoEntity loginInfoEntity) {

    }
    @Transactional
    @Override
    public void saveOrUpdate(LoginInfoEntity loginInfoEntity) {
        baseDao.saveOrUpdate(loginInfoEntity);
    }
}
