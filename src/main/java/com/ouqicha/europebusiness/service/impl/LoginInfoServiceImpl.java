package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;
import com.ouqicha.europebusiness.dao.LoginInfoDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:17:22
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {
    @Autowired
    LoginInfoDao loginInfoDao;
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public void changLoginInfo(int userId) {
        LoginInfoEntity one = loginInfoDao.findOne(userId);
        if (one != null) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            one.setLastLoginTime(timestamp);
            one.setGmtUpdate(timestamp);
            loginInfoDao.saveOrUpdate(one);
        } else {
            AccountEntity accountEntity = userInfoDao.get(userId);
            LoginInfoEntity entity = new LoginInfoEntity();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            entity.setGmtCreate(timestamp);
            entity.setGmtUpdate(timestamp);
            entity.setLastLoginTime(timestamp);
            entity.setAccountEntity(accountEntity);
            loginInfoDao.saveOrUpdate(entity);
        }
    }

    @Override
    public LoginInfoEntity findOne(int userId) {
        return loginInfoDao.findOne(userId);
    }
}
