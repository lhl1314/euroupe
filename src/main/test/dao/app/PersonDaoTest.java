package dao.app;

import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.PersonVO;
import com.ouqicha.europebusiness.dao.PersonDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/19 0019
 * Time:16:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class PersonDaoTest {
    @Autowired
    PersonDao personDao;
    @Autowired
    Mapper mapper;
    @Test
    public void getOne(){
        PersonEntity one = personDao.getOne(1);
        PersonVO vo = mapper.map(one, PersonVO.class);
        System.out.println(vo);
    }
}
