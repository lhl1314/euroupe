package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.SessionEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SessionDaoImpl implements SessionDao {
    @Autowired
    private BaseDao<SessionEntity> baseDao;

    @Override
    @Transactional
    public SessionEntity findSession(String sessionId) {
        String hql="From SessionEntity where cookie=?";
        return baseDao.get(hql, new Object[]{sessionId});
    }

    @Override
    @Transactional
    public void updateSessionByUserId(int userId, String sessionId) {
        deleteSessionByUserId(userId, sessionId);//清理之前该用户的session(其他设备登陆)
        SessionEntity sessionEntity = findSession(sessionId);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(userId);
        sessionEntity.setAccountEntity(accountEntity);
        /**
         * 新添加
         */

    }

    @Override
    public void findSessionByUserId(int userId) {

    }

    @Override
    public int deleteSessionByUserId(int userId, String sessionId) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(userId);
        String hql="delete SessionEntity s where s.accountEntity = ? and s.cookie != '"+sessionId+"'";
        return baseDao.executeHql(hql, new AccountEntity[]{accountEntity});
    }


}
