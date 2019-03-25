package dao.app;

import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyAuthenticationVo;
import com.ouqicha.europebusiness.dao.CompanyAuthenticationDao;
import com.ouqicha.europebusiness.dao.CompanyDao;
import jdk.nashorn.internal.ir.EmptyNode;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/15 0015
 * Time:15:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CompanyAuthenticationDaoTest {
    @Autowired
    CompanyAuthenticationDao companyAuthenticationDao;

    @Autowired
    CompanyDao companyDao;
    @Autowired
    Mapper mapper;
    @Test
    public void add(){
        CompanyAuthenticationEntity entity=new CompanyAuthenticationEntity();
        entity.setAlsoAuthentication(0);
        entity.setCompanyId(5);
        entity.setDocumentType("身份证");
        entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        companyAuthenticationDao.saveOrUpdate(entity);
    }
    @Test
    public void getOne(){
        CompanyAuthenticationEntity entity = companyAuthenticationDao.getOneByCompanyId(1);
//        CompanyAuthenticationEntity one = companyAuthenticationDao.getOne(1);
        CompanyAuthenticationVo vo = mapper.map(entity, CompanyAuthenticationVo.class);
        System.out.println(vo);

    }

    @Test
    public void getByPage(){
        List<CompanyAuthenticationEntity> page = companyAuthenticationDao.getByPage(1, 1);
        System.out.println(page);
    }
}
