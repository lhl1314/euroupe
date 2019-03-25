package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AdviceEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.AdviceVo;
import com.ouqicha.europebusiness.dao.AdviceDao;
import com.ouqicha.europebusiness.dao.UserDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/19 0019
 * Time:15:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class AdviceDaoTest {

    @Autowired
    Mapper mapper;
    @Autowired
    AdviceDao adviceDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Test
    public void getOne(){
        AdviceEntity entity = adviceDao.getOne(1);
        AdviceVo vo = mapper.map(entity, AdviceVo.class);
        AccountEntity accountEntity = userInfoDao.get(10);
        AccountVO accountVO = mapper.map(accountEntity, AccountVO.class);
        vo.setAccountVO(accountVO);
        System.out.println(vo);
        System.out.println(accountVO);
    }

    @Test
    public void count(){
        List<AdviceEntity> list = adviceDao.getAdvicePage(1, 1);
        List<AdviceVo> voList = Utils.setDozerList(mapper, list, AdviceVo.class);
        voList.forEach(t-> System.out.println(t));
    }
    @Test
    public void dasf(){
        System.out.println(adviceDao.sqlCount());
    }
}
