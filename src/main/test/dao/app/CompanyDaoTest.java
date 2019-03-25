package dao.app;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.ImportExportEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.bean.vo.PersonVO;
import com.ouqicha.europebusiness.dao.*;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CompanyDaoTest {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    ImportExportDao importExportDao;
    @Autowired
    PersonDao personDao;
    @Autowired
    Mapper mapper;
    @Autowired
    UserInfoDao userInfoDao;
    @Test
    public void getOne(){
        CompanyEntity entity = companyDao.findOneById(2);
        CompanyVO companyVO = mapper.map(entity, CompanyVO.class);
        System.out.println(companyVO);
    }

    @Test
    public void get(){
        List<CompanyEntity> list = companyDao.getAllCompanyList();
        List<CompanyVO> voList = Utils.setDozerList(mapper, list, CompanyVO.class);
        voList.forEach(t-> System.out.println(t));
    }


    @Test
    public void getOnePerson(){
        PersonEntity entity = personDao.getOne(6);
        PersonVO vo = mapper.map(entity, PersonVO.class);
        System.out.println(vo);
    }

    @Test
    public void saveImprotExportCompany(){
        CompanyEntity one = companyDao.findOneById(5);
        ImportExportEntity exportEntity=new ImportExportEntity();
        exportEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        exportEntity.setImportChina(1);
        exportEntity.setInvestmentRatio("23%");
        exportEntity.setImportExportCompany(one);
        importExportDao.saveOrUpdate(exportEntity);
    }

    @Test
    public void fasdfas(){
        AccountEntity accountEntity = userInfoDao.get(3);
        CompanyEntity entity=new CompanyEntity();
        entity.setAddress("中国安穗宿州");
        companyDao.saveOrUpdateCompany(entity);
        accountEntity.setCompanyByCompanyId(entity);
        userInfoDao.saveOrUpdate(accountEntity);
        ImportExportEntity importExportEntity=new ImportExportEntity();
        importExportEntity.setImportChina(1);
        importExportEntity.setImportExportCompany(entity);
        importExportDao.saveOrUpdate(importExportEntity);
    }
}
