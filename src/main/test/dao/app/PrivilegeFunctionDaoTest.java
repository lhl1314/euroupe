package dao.app;

import com.ouqicha.europebusiness.bean.entity.PrivilegeFunctionEntity;
import com.ouqicha.europebusiness.bean.vo.PrivilegeFunctionVo;
import com.ouqicha.europebusiness.dao.PrivilegeFunctionDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/14 0014
 * Time:17:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class PrivilegeFunctionDaoTest {
    @Autowired
    PrivilegeFunctionDao privilegeFunctionDao;
    @Autowired
    Mapper mapper;
    @Test
    public void getOne(){
        PrivilegeFunctionEntity one = privilegeFunctionDao.getOne(1);
        PrivilegeFunctionVo vo = mapper.map(one, PrivilegeFunctionVo.class);
        System.out.println(vo);
    }
}
