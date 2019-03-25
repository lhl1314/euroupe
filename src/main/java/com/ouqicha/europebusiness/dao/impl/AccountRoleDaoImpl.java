package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;
import com.ouqicha.europebusiness.dao.AccountRoleDao;
import com.ouqicha.europebusiness.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/18 0018
 * Time:10:32
 */
@Repository
public class AccountRoleDaoImpl implements AccountRoleDao {
    @Autowired
    BaseDao<AccountRoleEntity> baseDao;

    @Transactional
    @Override
    public void saveOrUpdateAccountRole(AccountRoleEntity accountRoleEntity) {
        baseDao.saveOrUpdate(accountRoleEntity);
    }

    @Transactional
    @Override
    public void deleteAccountRole(AccountRoleEntity accountRoleEntity) {
        baseDao.delete(accountRoleEntity);
    }

    @Transactional
    @Override
    public AccountRoleEntity findOne(int id) {
        String hql="from AccountRoleEntity where id=?";
        AccountRoleEntity roleEntity = baseDao.get(hql, new Object[]{id});
        return roleEntity;
    }

    @Transactional
    @Override
    public List<AccountRoleEntity> getRoleListAccount(int roleId) {
        String hql="from AccountRoleEntity where role_id=?";
        List<AccountRoleEntity> roleEntities = baseDao.find(hql, new Object[]{roleId});
        return roleEntities;

    }
}
