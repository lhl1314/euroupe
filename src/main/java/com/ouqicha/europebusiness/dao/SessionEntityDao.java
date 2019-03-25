package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.SessionEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.util.SerializableUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.Date;


public class SessionEntityDao extends EnterpriseCacheSessionDAO {

    @Autowired
    private BaseDao<AccountEntity> baseDao;
    @Autowired
    private BaseDao<SessionEntity> sessionDao;
    private Logger log = Logger.getLogger(SessionEntityDao.class);

    @Transactional
    @Override
    public Serializable create(Session session) {
        System.out.println("+++++++++++++++++create+++++++++++++++++++");
        // 先保存到缓存中
        Serializable cookie = super.create(session);
        // 新建一个SessionEntity，然后保存到数据库

        SessionEntity entity = new SessionEntity();
        entity.setSession(SerializableUtils.serializ(session));
        entity.setCookie(cookie.toString());
        try {
            sessionDao.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cookie;
    }

    @Transactional
    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("***************update******************");
        log.debug("***************update******************");
        super.update(session);


        SessionEntity entity = getEntity(session.getId());
        System.out.println("***************update111111******************");
        log.debug("***************update11111******************");
        if(entity != null){
            //如果登录成功，更新用户id
//            try{
//                Subject subject = SecurityUtils.getSubject();
//                if (subject.isAuthenticated()){
//                    AccountVO accountVO = (AccountVO) subject.getPrincipal();
//
//                    System.out.println("---------***************AccountVO******************---------"+accountVO);
//                    AccountEntity accountEntity = new AccountEntity();
//                    accountEntity.setId(accountVO.getId());
//                    entity.setAccountEntity(accountEntity);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }

            entity.setSession(SerializableUtils.serializ(session));
//            sessionDao.update(entity);
        }
    }

    @Transactional
    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        System.out.println("----------------readSession------------------");
        Session session = null;
        try{
            session = super.readSession(sessionId);
        } catch(Exception e){
            e.printStackTrace();
        }

        // 如果session已经被删除，则从数据库中查询session
        if(session == null){
            SessionEntity entity = getEntity(sessionId);

            if(entity != null){
                session = (Session) SerializableUtils.deserializ(entity.getSession());
            }
        }
        // 如果是APP则更新lastAccessTime
//        AccountEntity user = getUser(sessionId);
//        if(user != null){// 如果该用户是APP用户（user不为空说明就是），则判断session是否过期，如果过期则修改最后访问时间
//        ((SimpleSession)session).setLastAccessTime(new Date());
//        }

         return session;
    }

    @Transactional
    @Override
    public void delete(Session session) {
        System.out.println("----------------deletedeletedelete------------------");
        super.delete(session);
    }

    private AccountEntity getUser(Serializable sessionId){
        String hql = "from AccountEntity user where user.cookie ='" + sessionId + "'";
        return baseDao.get(hql, new String[]{});
    }

    private SessionEntity getEntity(Serializable sessionId){
        String hql = "from SessionEntity entity where entity.cookie ='" + sessionId + "'";
        return sessionDao.get(hql, new String[]{});
    }

    private boolean isExpire(Session session){
        long timeout = session.getTimeout();
        long lastTime = session.getLastAccessTime().getTime();
        long current = new Date().getTime();
        if((lastTime + timeout) > current){
            return false;
        }
        return true;
    }

    public BaseDao<AccountEntity> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<AccountEntity> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao<SessionEntity> getSessionDao() {
        return sessionDao;
    }

    public void setSessionDao(BaseDao<SessionEntity> sessionDao) {
        this.sessionDao = sessionDao;
    }
}
