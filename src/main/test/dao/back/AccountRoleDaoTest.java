package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;
import com.ouqicha.europebusiness.dao.AccountRoleDao;
import com.ouqicha.europebusiness.dao.RoleDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
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
 * Date:2019/2/18 0018
 * Time:10:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class AccountRoleDaoTest {
    @Autowired
    AccountRoleDao accountRoleDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    Mapper mapper;
    @Test
    public void add(){
        RoleEntity role = roleDao.findPermissionByRole(3);
        AccountEntity accountEntity = userInfoDao.findByMobile("添加测试4");
        AccountRoleEntity accountRoleEntity=new AccountRoleEntity();
        accountRoleEntity.setAccountByAccountId(accountEntity);
        accountRoleEntity.setRoleByRoleId(role);
        accountRoleDao.saveOrUpdateAccountRole(accountRoleEntity);
    }
    @Test
    public void delete(){
        AccountRoleEntity accountRoleEntity = accountRoleDao.findOne(7);
        accountRoleDao.deleteAccountRole(accountRoleEntity);
    }

    @Test
    public void findOne(){
        AccountRoleEntity one = accountRoleDao.findOne(1);
        AccountRoleVO vo = mapper.map(one, AccountRoleVO.class);
        System.out.println(vo);
    }

    @Test
    public void getOne(){
        List<AccountRoleEntity> listAccount = accountRoleDao.getRoleListAccount(3);

    }
}
