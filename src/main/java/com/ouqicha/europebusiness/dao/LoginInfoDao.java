package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:16:43
 */
public interface LoginInfoDao {
    /**
     * 找到一个用户的登录信息
     * @param userId
     * @return
     */
    LoginInfoEntity findOne(int userId);

    /**
     * 添加一条登录信息
     * @param loginInfoEntity
     */
    void add(LoginInfoEntity loginInfoEntity);

    /**
     * 更新一条登录信息
     * @param loginInfoEntity
     */
    void update(LoginInfoEntity loginInfoEntity);

    /**
     * 添加或修改登录信息
     * @param loginInfoEntity
     */
    void saveOrUpdate(LoginInfoEntity loginInfoEntity);
}
