package dao.back;

import com.ouqicha.europebusiness.bean.entity.NewsEntity;
import com.ouqicha.europebusiness.bean.vo.NewsVo;
import com.ouqicha.europebusiness.dao.NewsDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class NewsDaoTest {
    @Autowired
    NewsDao newsDao;
    @Autowired
    Mapper mapper;
    @Test
    public void findAll(){
        List<NewsEntity> all = newsDao.findAll();
        all.forEach(t-> System.out.println(t));
        for (NewsEntity entity:all){
            NewsVo vo = mapper.map(entity, NewsVo.class);
            System.out.println(vo);
        }
    }
}
