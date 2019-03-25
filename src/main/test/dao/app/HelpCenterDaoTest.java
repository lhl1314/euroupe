package dao.app;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;
import com.ouqicha.europebusiness.bean.vo.HelpCenterHeaderVo;
import com.ouqicha.europebusiness.bean.vo.HelpCenterVo;
import com.ouqicha.europebusiness.dao.HelpCenterDao;
import com.ouqicha.europebusiness.dao.HelpCenterHeaderDao;
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
 * Date:2019/3/12 0012
 * Time:17:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HelpCenterDaoTest {
    @Autowired
    HelpCenterDao helpCenterDao;
    @Autowired
    Mapper mapper;
    @Autowired
    HelpCenterHeaderDao helpCenterHeaderDao;
    @Test
    public void getAll(){
        List<HelpCenterEntity> centerEntities = helpCenterDao.getHelpCenterBySerialNumber(1);
        HelpCenterVo vo = mapper.map(centerEntities, HelpCenterVo.class);
        System.out.println(vo);
    }

    @Test
    public void fasdf(){
        List<HelpCenterHeaderEntity> daoAll = helpCenterHeaderDao.getAll();
        List<HelpCenterHeaderVo> vos = Utils.setDozerList(mapper, daoAll, HelpCenterHeaderVo.class);
        vos.forEach(t-> System.out.println(t));
    }
}
