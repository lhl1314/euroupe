package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.ProvinceEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:40
 */
public interface ProvinceDao {
    /**
     * 获取一级地区的所有二级地区
     * @param countryId
     * @return
     */

    List<ProvinceEntity>getProvinceList(int countryId);

    /**
     * 获取二级地区分页数据
     * @param countryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProvinceEntity>getProvinceListPage(int countryId,int pageNum,int pageSize);
}
