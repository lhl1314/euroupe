package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.NewsEntity;
import com.ouqicha.europebusiness.bean.vo.NewsVo;
import com.ouqicha.europebusiness.util.Page;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:16:49
 */
public interface NewsService {
    /**
     * 后台
     */
    /**
     * 添加新闻
     *
     * @param newsEntity
     */
    void add(NewsEntity newsEntity, String newsLogo);

    /**
     * 获取所有的新闻动态
     *
     * @return
     */
    List<NewsVo> getAllNews();

    /**
     * 获取新闻的分页
     *
     * @param pageId
     * @param pageSize
     * @return
     */
    Page<NewsVo> getNewsPage(int pageId, int pageSize);

    /**
     * 获取新闻的详情
     *
     * @param id
     * @return
     */
    NewsVo getNews(int id);


    /**
     * 冻结或者解冻新闻
     *
     * @param id
     */
    void freezeOrUnfreezeNews(int id);

    /**
     * 删除新闻
     *
     * @param id
     */
    void deleteNews(int id);
}
