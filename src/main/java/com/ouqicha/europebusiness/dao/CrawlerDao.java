package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.EnuropEntity;

public interface CrawlerDao {
    int saveEuropeCompany(EnuropEntity enuropEntity) throws Exception;
}
