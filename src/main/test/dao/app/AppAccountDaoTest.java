package dao.app;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.dao.PersonDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/6 0006
 * Time:13:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class AppAccountDaoTest {
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    PersonDao personDao;
    @Autowired
    Mapper mapper;
    @Test
    public void addPerson(){
        PersonEntity entity=new PersonEntity();
        entity.setDuty("发阿斯蒂芬");
        personDao.saveOrUpdate(entity);
    }

    @Test
    public void updateInformation(){
        AccountEntity accountEntity = userInfoDao.get(31);
        CompanyEntity companyEntity = companyDao.findOneById(1);
        PersonEntity personEntity=new PersonEntity();
        personEntity.setCompanyByCompanyId(companyEntity);
        accountEntity.setCompanyByCompanyId(companyEntity);
        personEntity.setDuty("哈哈哈哈哈");

        userInfoDao.saveOrUpdate(accountEntity);
        personDao.saveOrUpdate(personEntity);

    }


    @Test
    public void sa(){
        CompanyEntity vo=new CompanyEntity();
        vo.setAddress("你说这个Id是个什么情况");
        System.out.println("添加数据库之前"+vo);
        companyDao.saveOrUpdateCompany(vo);
        System.out.println("添加数据库之后"+vo);
    }


    @Test
    public void getOnePerson(){
        AccountEntity entity = userInfoDao.get(1);
        AccountVO vo1 = mapper.map(entity, AccountVO.class);
        System.out.println("第一次"+vo1);
    }


    @Test
    public void getOneAccount(){
        AccountEntity entity = userInfoDao.get(1);
        AccountVO vo = mapper.map(entity, AccountVO.class);
        System.out.println(vo);
    }
}
