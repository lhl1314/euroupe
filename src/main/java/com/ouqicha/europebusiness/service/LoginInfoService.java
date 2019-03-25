package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:17:22
 */
public interface LoginInfoService {
    /**
     * 修改账户的登录信息，如果没登录过，添加一条
     *
     * @param userId
     */
    void changLoginInfo(int userId);

    /**
     * 找一条登录信息
     * @param userId
     * @return
     */
    LoginInfoEntity findOne(int userId);
}
