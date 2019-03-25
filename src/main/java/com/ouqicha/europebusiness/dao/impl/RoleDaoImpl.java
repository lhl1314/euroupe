package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:14:54
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    BaseDao<RoleEntity>baseDao;
    @Transactional
    @Override
    public List<RoleEntity> findAll() {
        String hql="from RoleEntity";
        List<RoleEntity> roleEntities = baseDao.find(hql);
        return roleEntities;
    }
    @Transactional
    @Override
    public RoleEntity findPermissionByRole(int roleId) {
        String hql="from RoleEntity where id=?";
        RoleEntity entity = baseDao.get(hql, new Object[]{roleId}, null);
        return entity;
    }
}
