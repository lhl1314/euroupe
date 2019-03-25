package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CountryEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:39
 */
public interface CountryDao {
    /**
     * 获取所有的国家一级地区
     * @return
     */
    List<CountryEntity>getAll();

    /**
     * 获取国家分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CountryEntity>getCountrysByPage(int pageNum,int pageSize);
}
