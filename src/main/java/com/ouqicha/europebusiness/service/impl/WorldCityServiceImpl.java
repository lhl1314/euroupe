package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.CityEntity;
import com.ouqicha.europebusiness.bean.entity.CountryEntity;
import com.ouqicha.europebusiness.bean.entity.PrefectureEntity;
import com.ouqicha.europebusiness.bean.entity.ProvinceEntity;
import com.ouqicha.europebusiness.bean.vo.*;
import com.ouqicha.europebusiness.dao.CityDao;
import com.ouqicha.europebusiness.dao.CountryDao;
import com.ouqicha.europebusiness.dao.PrefectureDao;
import com.ouqicha.europebusiness.dao.ProvinceDao;
import com.ouqicha.europebusiness.service.WorldCityService;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/6 0006
 * Time:9:16
 */
@Service
public class WorldCityServiceImpl implements WorldCityService {
    @Autowired
    CountryDao countryDao;
    @Autowired
    ProvinceDao provinceDao;
    @Autowired
    CityDao cityDao;
    @Autowired
    PrefectureDao prefectureDao;
    @Autowired
    Mapper mapper;
    @Override
    public ResponseData<List<CountryVo>> getCountryList(int pageNum,int pageSize) {
        ResponseData<List<CountryVo>>responseData=new ResponseData<>();

        List<CountryEntity> entities = countryDao.getCountrysByPage(pageNum, pageSize);
        if (entities!=null&&!entities.isEmpty()){
            List<CountryVo> voList = Utils.setDozerList(mapper, entities, CountryVo.class);
            responseData.setData(voList);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("国家地区");
            return responseData;
        }
        return null;
    }
    @Override
    public ResponseData<List<ProvinceVo>> getProvinceList(int countryId,int pageNum,int pageSize) {
        List<ProvinceEntity> all = provinceDao.getProvinceListPage(countryId,pageNum,pageSize);
        ResponseData<List<ProvinceVo>>responseData=new ResponseData<>();
        if (all!=null&&!all.isEmpty()){
            List<ProvinceVo> voList = Utils.setDozerList(mapper, all, ProvinceVo.class);
            responseData.setData(voList);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("省级地区");
            return responseData;
        }
        return null;
    }




    @Override
    public ResponseData<List<CityVo>> getCityList(int provinceId,int pageNum,int pageSize) {
        List<CityEntity> allCity = cityDao.getCityByPage(provinceId,pageNum,pageSize);
        ResponseData<List<CityVo>>responseData=new ResponseData<>();
        if (allCity!=null&&!allCity.isEmpty()){
            List<CityVo> voList = Utils.setDozerList(mapper, allCity, CityVo.class);
            responseData.setData(voList);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("三级市区");
            return responseData;
        }
        return null;
    }

    @Override
    public ResponseData<List<PrefectureVo>> getPrefectureList(int cityId,int pageNum,int pageSize) {
        List<PrefectureEntity> entities = prefectureDao.getPrefectureListPage(cityId,pageNum,pageSize);
        ResponseData<List<PrefectureVo>>responseData=new ResponseData<>();
        if (entities!=null&&!entities.isEmpty()){
            List<PrefectureVo> voList = Utils.setDozerList(mapper, entities, PrefectureVo.class);
            responseData.setData(voList);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("四级县区");
            return responseData;
        }
        return null;
    }
}
