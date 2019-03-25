package dao.back;

import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.bean.vo.DialogueVo;
import com.ouqicha.europebusiness.dao.DialogueDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:11:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class DialogueDaoTest {
    @Autowired
    DialogueDao dialogueDao;
    @Autowired
    Mapper mapper;

    /**
     * 查找所有信息
     */
    @Test
    public void findAll(){
        List<DialogueEntity> entities = dialogueDao.findAll();
        for (DialogueEntity entity:entities){
            DialogueVo vo = mapper.map(entity, DialogueVo.class);
            System.out.println(vo);
        }
    }

    /**
     * 添加对话信息
     */
    @Test
    public void add(){
        DialogueEntity entity=new DialogueEntity();
        entity.setAcceptId(12);
        entity.setSendId(20);
        entity.setSendTime(new Timestamp(System.currentTimeMillis()));
        dialogueDao.add(entity);
        DialogueVo vo = mapper.map(entity, DialogueVo.class);
        System.out.println(vo);
    }

    /**
     * 查找对话信息
     */
    @Test
    public void findOne(){
        DialogueEntity entity = dialogueDao.findOne(2);
        DialogueVo vo = mapper.map(entity, DialogueVo.class);
        System.out.println(vo);
    }
    @Test
    public void getTwoDialogue(){
        List<DialogueEntity> dialogues = dialogueDao.getDialogues("1912", "1219");
        for (DialogueEntity entity:dialogues){
            DialogueVo vo = mapper.map(entity, DialogueVo.class);
            System.out.println(vo);
        }
    }

    @Test
    public void noReadCount(){
        Long count = dialogueDao.noReadCount(19, 0);
        System.out.println(count);
    }


    @Test
    public void getMeNoRead(){
        List<DialogueEntity> read = dialogueDao.getMeNoRead(12, 0);
    }
}
