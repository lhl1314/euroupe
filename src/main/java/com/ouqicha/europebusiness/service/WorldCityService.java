package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.vo.*;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/6 0006
 * Time:9:13
 */
public interface WorldCityService {
    /**
     * 获取国家一级地区
     * @return
     */
    ResponseData<List<CountryVo>>getCountryList(int pageNum,int pageSize);
    /**
     * 获取省级地区
     * @return
     */
    ResponseData<List<ProvinceVo>>getProvinceList(int countryId,int pageNum,int pageSize);

    /**
     * 中国个人获取市级地区
     * @param provinceId
     * @return
     */
    ResponseData<List<CityVo>>getCityList(int provinceId,int pageNum,int pageSize);

    /**
     * 中国个人获取县级地区
     * @param cityId
     * @return
     */
    ResponseData<List<PrefectureVo>>getPrefectureList(int cityId,int pageNum,int pageSize);
}
