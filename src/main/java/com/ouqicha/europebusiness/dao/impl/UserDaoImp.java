package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.UserEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.UserDao;

public class UserDaoImp implements UserDao {
    private BaseDao<UserEntity> baseDao;

    public BaseDao<UserEntity> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<UserEntity> baseDao) {
        this.baseDao = baseDao;
    }

    public UserEntity Login(String LoginName,String Password) {
        String hql="From TEmail where loginName=? and password=?";
        return baseDao.get(hql, new Object[]{LoginName,Password});
    }

    public UserEntity FindByEmail(String param) {
        String hql="From TEmail where email=?";
        return baseDao.get(hql, new Object[]{param});
    }

    public Integer count(String param) {
        String hql="Select count(*) From TEmail where email=?";
        Long s=baseDao.count(hql, new Object[]{param});
        return s.intValue();
    }

    public void saveOrUpdate(UserEntity T){
        baseDao.saveOrUpdate(T);
    }

    public void save(UserEntity T) throws Exception {
        baseDao.save(T);
    }

    public void update(UserEntity T){
        baseDao.update(T);
    }

    public UserEntity get(Integer id) {
        return baseDao.get(UserEntity.class, id);
    }
}
