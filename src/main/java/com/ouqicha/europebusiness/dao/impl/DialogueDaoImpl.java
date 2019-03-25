package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.DialogueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:11:17
 */
@Repository
public class DialogueDaoImpl implements DialogueDao {
    @Autowired
    BaseDao<DialogueEntity>baseDao;
    /**
     * 自己用sql写
     */
    @Transactional
    @Override
    public List<DialogueEntity> findAll() {
        String hql="from DialogueEntity";
        List<DialogueEntity> entities = baseDao.find(hql);
        return entities;
    }
    @Transactional
    @Override
    public void add(DialogueEntity entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public void updateDialogue(DialogueEntity entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public DialogueEntity findOne(int id) {
        String hql="from DialogueEntity where id=?";
        DialogueEntity entity = baseDao.get(hql, new Object[]{id}, null);
        return entity;
    }

    /**
     * 这里多个字段采用原生的sql写
     * @param sendConnectId
     * @param acceptConnectId
     * @return
     */
    @Transactional
    @Override
    public List<DialogueEntity> getDialogues(String sendConnectId, String acceptConnectId) {
        String hql="from DialogueEntity where connect_id=? or connect_id=?";
        List<DialogueEntity> entities = baseDao.find(hql, new Object[]{sendConnectId, acceptConnectId});
        return entities;
    }


    @Transactional
    @Override
    public Long noReadCount(int sendId, int noRead) {
        String hql="select count(*) from DialogueEntity where send_id=? and adminAlsoRead=?";
        Long count = baseDao.count(hql, new Object[]{sendId,noRead});
        return count;
    }
    @Transactional
    @Override
    public List<DialogueEntity> getDialoguesNoRead(int adminAlsoRead) {
        String hql="from DialogueEntity where adminAlsoRead=?";
        List<DialogueEntity> entities = baseDao.find(hql, new Object[]{adminAlsoRead});
        return entities;
    }

    @Transactional
    @Override
    public List<DialogueEntity> getMeNoRead(int acceptId, int alsoRead) {
        String hql="from DialogueEntity where accept_id=? and adminAlsoRead=? ";
        List<DialogueEntity> list = baseDao.find(hql, new Object[]{acceptId, alsoRead});
        return list;
    }
}
