package dao.app;

import com.ouqicha.europebusiness.bean.entity.CollectEntity;
import com.ouqicha.europebusiness.bean.vo.CollectVo;
import com.ouqicha.europebusiness.dao.CollectDao;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CollectDaoTest {
    @Autowired
    CollectDao collectDao;
    @Autowired
    Mapper mapper;

    @Test
    public void findAll(){
        List<CollectEntity> all = collectDao.getAll();
        List<CollectVo> voList = Utils.setDozerList(mapper, all, CollectVo.class);
        voList.forEach(t-> System.out.println(t));
    }

    @Test
    public void fa(){
        List<CollectEntity> entity = collectDao.getPageCollectEntity(1, 2, 1);
        List<CollectVo> voList = Utils.setDozerList(mapper, entity, CollectVo.class);
        voList.forEach(t-> System.out.println(t));

    }

    @Test
    public void count(){
        Long count = collectDao.collectCount(1);
        System.out.println(count);
    }
}
