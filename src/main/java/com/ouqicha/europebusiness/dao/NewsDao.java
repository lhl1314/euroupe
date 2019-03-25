package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.NewsEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:19
 */
public interface NewsDao {
    /**
     * 找到所有的新闻
     * @return
     */
    List<NewsEntity>findAll();


    /**
     * 添加新闻动态
     * @param newsEntity
     */
    void addNews(NewsEntity newsEntity,String newsLogo);

    /**
     * 通过id找一条新闻
     * @param id
     * @return
     */
    NewsEntity findOne(int id);
    /**
     * 删除新闻
     * @param id
     */
    void deleteNews(int id);

    /**
     * 修改新闻
     * @param newsEntity
     */
    void updateNews(NewsEntity newsEntity);

    /**
     * 获取新闻的sql数量
     * @return
     */
    Long getSqlCount();

    /**
     * 获取分页的数据
     * @param pageId
     * @param pageSize
     * @return
     */
    List<NewsEntity>getNewsLimit(int pageId,int pageSize);
}
