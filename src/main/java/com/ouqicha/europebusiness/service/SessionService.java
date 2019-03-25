package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.SessionEntity;

public interface SessionService {

    public SessionEntity findSession(String sessionId);

    public void updateSessionByUserId(int userId, String sessionId);
}
