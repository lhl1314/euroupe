package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
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
 * Date:2019/2/13 0013
 * Time:11:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class DaoTest {
   @Autowired
    UserInfoDao infoDao;
   @Autowired
    Mapper mapper;
    @Test
    public void tet1(){
        AccountEntity entity = infoDao.findByMobile("admin");
        AccountVO desc = mapper.map(entity, AccountVO.class);
        System.out.println("账户----"+infoDao.findByMobile("admin"));
    }
}
