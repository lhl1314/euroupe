package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.SessionEntity;
import com.ouqicha.europebusiness.dao.SessionDao;
import com.ouqicha.europebusiness.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public SessionEntity findSession(String sessionId) {
        return sessionDao.findSession(sessionId);
    }

    @Override
    public void updateSessionByUserId(int userId, String sessionId) {
        sessionDao.updateSessionByUserId(userId, sessionId);
    }
}
