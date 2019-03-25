package dao.back;

import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;
import com.ouqicha.europebusiness.bean.vo.HelpCenterHeaderVo;
import com.ouqicha.europebusiness.dao.HelpCenterDao;
import com.ouqicha.europebusiness.dao.HelpCenterHeaderDao;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.dozer.Mapping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/19 0019
 * Time:14:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HelpDaoTest {
    @Autowired
    Mapper mapper;
    @Autowired
    HelpCenterHeaderDao helpCenterDao;

    @Test
    public void getAllPage(){
        List<HelpCenterHeaderEntity> entities = helpCenterDao.getAll();
        List<HelpCenterHeaderVo> voList = Utils.setDozerList(mapper, entities, HelpCenterHeaderVo.class);
        voList.forEach(t-> System.out.println(t));
    }
}
