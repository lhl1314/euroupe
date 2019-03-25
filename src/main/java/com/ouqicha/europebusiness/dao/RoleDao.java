package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.RoleEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:14:53
 */
public interface RoleDao {
    /**
     * 找到所有角色以及权限
     * @return
     */
    List<RoleEntity>findAll();

    /**
     * 通过角色查找该角色的所有权限
     * @param roleId
     * @return
     */
    RoleEntity findPermissionByRole(int roleId);
}
