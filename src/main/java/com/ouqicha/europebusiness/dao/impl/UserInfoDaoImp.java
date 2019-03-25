package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.entity.UserEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserInfoDaoImp implements UserInfoDao {
    @Autowired
    private BaseDao<AccountEntity> baseDao;

//    public BaseDao<AccountEntity> getBaseDao() {
//        return baseDao;
//    }
//
//    public void setBaseDao(BaseDao<AccountEntity> baseDao) {
//        this.baseDao = baseDao;
//    }
    @Override
    public AccountEntity Login(String LoginName, String Password) {
        return null;
    }

    @Transactional
    @Override
    public AccountEntity findByEmail(String param) {
        String hql="From AccountEntity where email=?";
        return baseDao.get(hql, new Object[]{param});
    }

    @Transactional
    @Override
    public AccountEntity findByMobile(String param) {
        String hql="From AccountEntity where mobile=?";
        return baseDao.get(hql, new Object[]{param}, null);
    }

    @Override
    public Integer count(String param) {
        return null;
    }
    @Transactional
    @Override
    public void saveOrUpdate(AccountEntity accountEntity) {
        baseDao.saveOrUpdate(accountEntity);
    }

    @Transactional
    @Override
    public void save(AccountEntity accountEntity) throws Exception {
        baseDao.save(accountEntity);
    }

    @Override
    public void update(AccountEntity accountEntity) {

    }
    @Transactional
    @Override
    public AccountEntity get(Integer id) {
        String hql="From AccountEntity where id=?";
        return baseDao.get(hql, new Object[]{id}, null);
    }
    @Transactional
    @Override
    public List<AccountEntity> findAll() {
        String hql="From AccountEntity";
        List<AccountEntity> entities = baseDao.find(hql);
        return entities;
    }
    @Transactional
    @Override
    public List<AccountEntity> getByPageNum(int pageNum, int pageSize) {
        String hql="from AccountEntity";
        List<AccountEntity> entities = baseDao.find(hql, new Object[]{}, pageNum, pageSize);
        return entities;
    }

    @Transactional
    @Override
    public List<AccountEntity> getByPageAndState(int pageNum, int pageSize, int state) {
        String hql="from AccountEntity where state=?";
        List<AccountEntity> entities = baseDao.find(hql, new Object[]{state}, pageNum, pageSize);
        return entities;
    }

    @Transactional
    @Override
    public Long countOfAccount() {
        String hql="select count(*) from AccountEntity";
        Long count = baseDao.count(hql);
        return count;
    }

    @Transactional
    @Override
    public Long countOfAccountByState(int state) {
        String hql="select count(*) from AccountEntity where state=?";
        Long count = baseDao.count(hql, new Object[]{state});
        return count;
    }

    @Transactional
    @Override
    public List<AccountEntity> findAccountByState(int state) {
        String hql="from AccountEntity where state=?";
        List<AccountEntity> accountEntities = baseDao.find(hql, new Object[]{state});
        return accountEntities;
    }

    @Transactional
    @Override
    public AccountEntity getOneByIdAndState(int id, int state) {
        String hql="from AccountEntity where id=? and state=?";
        AccountEntity entity = baseDao.get(hql, new Object[]{id, state});
        return entity;
    }
}
