package dao.back;

import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.vo.RoleVO;
import com.ouqicha.europebusiness.dao.RoleDao;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:14:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class RoleDaoTest {
    @Autowired
    Mapper mapper;
    @Autowired
    RoleDao roleDao;

    /**
     * 找到所有的角色和权限
     */
    @Test
    public void findAll(){
        List<RoleEntity> entities = roleDao.findAll();
        List<RoleVO>roleVOS=new ArrayList<>();
        for (RoleEntity entity:entities){
            RoleVO vo = mapper.map(entity, RoleVO.class);
            roleVOS.add(vo);
        }

        roleVOS.forEach(t-> System.out.println(t));
    }


    /**
     * 通过角色Id找该角色以及角色下的权限
     */
    @Test
    public void findPermissionByRole(){
        RoleEntity role = roleDao.findPermissionByRole(1);
        RoleVO vo = mapper.map(role, RoleVO.class);
        System.out.println(vo);
    }

    @Test
    public void get(){
        RoleEntity roleEntity = roleDao.findPermissionByRole(3);

    }


}
