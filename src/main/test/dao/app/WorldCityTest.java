package dao.app;

import com.ouqicha.europebusiness.bean.entity.CityEntity;
import com.ouqicha.europebusiness.bean.entity.CountryEntity;
import com.ouqicha.europebusiness.bean.entity.PrefectureEntity;
import com.ouqicha.europebusiness.bean.entity.ProvinceEntity;
import com.ouqicha.europebusiness.bean.vo.CityVo;
import com.ouqicha.europebusiness.bean.vo.CountryVo;
import com.ouqicha.europebusiness.bean.vo.PrefectureVo;
import com.ouqicha.europebusiness.bean.vo.ProvinceVo;
import com.ouqicha.europebusiness.dao.CityDao;
import com.ouqicha.europebusiness.dao.CountryDao;
import com.ouqicha.europebusiness.dao.PrefectureDao;
import com.ouqicha.europebusiness.dao.ProvinceDao;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:13:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class WorldCityTest {
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

    /**
     * 所有的一级区域
     */
    @Test
    public void getCountry(){
        List<CountryEntity> entities = countryDao.getAll();
        List<CountryVo> voList = Utils.setDozerList(mapper, entities, CountryVo.class);
        for (CountryVo v:voList){
            System.out.println(v);
        }
    }

    /**
     * 二级省区
     */
    @Test
    public void getProvince(){

        List<ProvinceEntity> all = provinceDao.getProvinceList(1);
        List<ProvinceVo> voList = Utils.setDozerList(mapper,all,ProvinceVo.class);
        for (ProvinceVo v:voList){
            System.out.println(v);
        }
    }

    /**
     * 三级市区
     */
    @Test
    public void getCities(){
        List<CityEntity> allCity = cityDao.getAllCity(12);
        List<CityVo> voList = Utils.setDozerList(mapper, allCity, CityVo.class);
        for (CityVo v:voList){
            System.out.println(v);
        }
    }

    /**
     * 四级县区
     *
     */
    @Test
    public void getPrefectures(){
        List<PrefectureEntity> s = prefectureDao.getPrefectureList(33);

        List<PrefectureVo> voList = Utils.setDozerList(mapper, s, PrefectureVo.class);
        for (PrefectureVo v:voList){
            System.out.println(v);
        }
    }


    @Test
    public void  getCountrys(){
        List<CountryEntity> countrys = countryDao.getCountrysByPage(1, 1);
        List<CountryVo> voList = Utils.setDozerList(mapper, countrys, CountryVo.class);
        voList.forEach(t-> System.out.println(t));
    }
}
