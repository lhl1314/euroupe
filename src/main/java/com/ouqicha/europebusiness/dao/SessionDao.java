package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.SessionEntity;

public interface SessionDao {
    public SessionEntity findSession(String sessionId);
    public void updateSessionByUserId(int userId, String sessionId);
    public void findSessionByUserId(int userId);
    public int deleteSessionByUserId(int userId, String sessionId);
}
