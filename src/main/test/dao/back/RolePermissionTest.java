package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.PermissionVO;
import com.ouqicha.europebusiness.bean.vo.RolePermissionVO;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.UserInfoService;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:11:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class RolePermissionTest {
    @Autowired
    Mapper mapper;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserInfoService userInfoService;
    @Test
    public void findAllRoles(){
        AccountEntity user = userInfoDao.findByMobile("admin");
        AccountVO vo = mapper.map(user, AccountVO.class);
        Collection<AccountRoleVO> roles = vo.getAccountRoles();
        Set<String>permissionSet=new HashSet<>();
        for(AccountRoleVO role : roles){
            Collection<RolePermissionVO> permissions = role.getRole().getRolePermissions();
            for (RolePermissionVO rolePermissionVO:permissions){
                PermissionVO permission = rolePermissionVO.getPermission();
                String permissionName = permission.getPermissionName();
                permissionSet.add(permissionName);
            }
        }
        System.out.println(permissionSet);
    }


    @Test
    public void afd(){
        Set<String> strings = userInfoService.queryUserRole("admin");
        System.out.println(strings);
    }
}
