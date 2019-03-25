package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.LoginInfoEntity;
import com.ouqicha.europebusiness.dao.LoginInfoDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:16:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class LoginInfoDaoTest {
    @Autowired
    Mapper mapper;
    @Autowired
    LoginInfoDao loginInfoDao;

    /**
     * 查找一条登录信息
     */
    @Test
    public void findOne(){
        LoginInfoEntity one = loginInfoDao.findOne(9);
        System.out.println(one);
    }

    /**
     * 修改一条登录信息
     */
    @Test
    public void update(){
        LoginInfoEntity one = loginInfoDao.findOne(9);
        one.setDeviceInfo("哈哈");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        one.setLastLoginTime(timestamp);
        loginInfoDao.saveOrUpdate(one);
    }

    /**
     * 刚添加的账户登录添加登录信息
     */
    @Test
    public void add(){
        LoginInfoEntity infoEntity=new LoginInfoEntity();
        infoEntity.setDeviceInfo("哈哈");
        AccountEntity entity = new AccountEntity();
        entity.setId(12);
        infoEntity.setAccountEntity(entity);
        loginInfoDao.saveOrUpdate(infoEntity);
    }

    /**
     * 关于Timestamp的时间测试
     */
    @Test
    public void test2(){
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        System.out.println(nousedate);
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
