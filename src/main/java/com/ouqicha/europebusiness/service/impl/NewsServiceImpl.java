package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.NewsEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.bean.vo.NewsVo;
import com.ouqicha.europebusiness.dao.NewsDao;
import com.ouqicha.europebusiness.service.NewsService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.PageControl;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:16:50
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Autowired
    Mapper mapper;

    @Override
    public void add(NewsEntity newsEntity, String newsLogo) {
        newsDao.addNews(newsEntity, newsLogo);
    }

    @Override
    public List<NewsVo> getAllNews() {
        List<NewsEntity> entities = newsDao.findAll();
        if (entities!=null&&!entities.isEmpty()){
            List<NewsVo> voList = Utils.setDozerList(mapper, entities, NewsVo.class);
            return voList;
        }
      return null;
    }

    @Override
    public Page<NewsVo> getNewsPage(int pageId, int pageSize) {
        Long sqlCount = newsDao.getSqlCount();
        int sqlTotalCount = sqlCount.intValue();
        int pageTotal = (int) Math.ceil(sqlTotalCount / pageSize);
        List<NewsEntity> newsEntities = newsDao.getNewsLimit(pageId, pageSize);
       if (newsEntities!=null&&!newsEntities.isEmpty()){
           List<NewsVo> voList = Utils.setDozerList(mapper, newsEntities, NewsVo.class);
           PageControl<NewsVo> pageControl = new PageControl<>();
           Page<NewsVo> page = pageControl.setPage(pageId - 1, pageTotal, voList);
           return page;
       }
       return null;
    }

    @Override
    public NewsVo getNews(int id) {
        NewsEntity entity = newsDao.findOne(id);
        NewsVo vo = mapper.map(entity, NewsVo.class);
        return vo;
    }

    @Override
    public void freezeOrUnfreezeNews(int id) {
        NewsEntity entity = newsDao.findOne(id);
        if (entity.getIsDelete() == 0) {
            entity.setIsDelete(1);
        } else {
            entity.setIsDelete(0);
        }
        newsDao.updateNews(entity);
    }

    @Override
    public void deleteNews(int id) {
        newsDao.deleteNews(id);
    }
}
