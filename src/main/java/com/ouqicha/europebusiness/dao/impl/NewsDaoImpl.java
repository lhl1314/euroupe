package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.NewsEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:20
 */
@Repository
public class NewsDaoImpl implements NewsDao {
    @Autowired
    private BaseDao<NewsEntity> baseDao;
    @Transactional
    @Override
    public List<NewsEntity> findAll() {
        String hql="from NewsEntity";
        List<NewsEntity> entities = baseDao.find(hql);
        return entities;
    }

    @Transactional
    @Override
    public void addNews(NewsEntity newsEntity,String newsLogo) {
        newsEntity.setNewLogo(newsLogo);
        newsEntity.setPublishTime(new Timestamp(System.currentTimeMillis()));
        newsEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        newsEntity.setIsDelete(0);
        baseDao.saveOrUpdate(newsEntity);
    }
    @Transactional
    @Override
    public NewsEntity findOne(int id) {
        String hql="from NewsEntity where id=?";
       return baseDao.get(hql,new Object[]{id},null);
    }
    @Transactional
    @Override
    public void deleteNews(int id) {
        String hql="from NewsEntity where id=?";
        NewsEntity entity = baseDao.get(hql, new Object[]{id}, null);
        baseDao.delete(entity);
    }
    @Transactional
    @Override
    public void updateNews(NewsEntity newsEntity) {
        baseDao.saveOrUpdate(newsEntity);
    }
    @Transactional
    @Override
    public Long getSqlCount() {
        String hql="select count(*) from NewsEntity";
        Long count = baseDao.count(hql);
        return count;
    }
    @Transactional
    @Override
    public List<NewsEntity> getNewsLimit(int pageId, int pageSize) {
        String hql="from NewsEntity";
        List<NewsEntity> entities = baseDao.find(hql, new Object[]{}, pageId, pageSize);
        return entities;
    }
}
