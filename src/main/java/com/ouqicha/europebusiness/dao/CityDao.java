package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CityEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:42
 */
public interface CityDao {
    /**
     * 获取二级地区的三级地区们
     * @param provinceId
     * @return
     */
    List<CityEntity>getAllCity(int provinceId);


    /**
     * 获取三级城市分页数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CityEntity>getCityByPage(int provinceId,int pageNum,int pageSize);
}
