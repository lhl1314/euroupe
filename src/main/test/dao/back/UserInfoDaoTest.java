package dao.back;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.dao.RoleDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.util.MD5Util;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.PageControl;
import org.dozer.Mapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/13 0013
 * Time:14:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserInfoDaoTest {
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    Mapper mapper;

    /**
     * 查找到所有的账户  成功
     */
    @Test
    public void findAllAccount(){
        List<AccountEntity> entities = userInfoDao.findAll();
        List<AccountVO>accountVOList=new ArrayList<>();
        for (AccountEntity entity:entities){
            AccountVO vo = mapper.map(entity,AccountVO.class);
            accountVOList.add(vo);
        }
        accountVOList.forEach(t-> System.out.println(t));
    }

    /**
     * 查找所有的角色  成功
     */
    @Test
    public void getAllRoles(){
        List<RoleEntity> all = roleDao.findAll();
        System.out.println(all);
    }


    /**
     * 通过手机号查找一个账户  成功
     */
    @Test
    public void findOne(){
        AccountEntity admin = userInfoDao.findByMobile("kefu");
        int i = admin.getAccountRolesById().size();
        Set<AccountRoleEntity>roleEntities=new HashSet<>();
        Collection<AccountRoleEntity> id = admin.getAccountRolesById();
        for (AccountRoleEntity entity:id){
            roleEntities.add(entity);
        }
        System.out.println(roleEntities.size());
//        System.out.println("数量"+i);
//        System.out.println("这是映射之前的账户"+admin);
//        AccountVO accountVO = mapper.map(admin, AccountVO.class);
//        System.out.println("这是映射之后的账户"+accountVO);
    }

    /**
     * 通过邮件获取一个账户  成功
     */
    @Test
    public void getOneByEmail(){
        AccountEntity entity = userInfoDao.findByEmail("1694190210@qq.com");
        AccountVO vo = mapper.map(entity, AccountVO.class);
        System.out.println(vo);
    }

    /**
     * 通过主键获取一个账户  成功
     */
    @Test
    public void getOne(){
        AccountEntity entity = userInfoDao.get(10);
        System.out.println(entity);
    }

    /**
     * 类似limit 语句  成功
     */
    @Test
    public void getByPage(){
        List<AccountEntity> entities = userInfoDao.getByPageNum(2, 2);

        List<AccountVO>voList=new ArrayList<>();
        for (AccountEntity entity:entities){
            AccountVO vo = mapper.map(entity, AccountVO.class);
            voList.add(vo);
        }
        voList.forEach(t-> System.out.println(t));
    }

    @Test
    public void findGetPageByState(){
        List<AccountEntity> entities = userInfoDao.getByPageAndState(1, 2, 1);
        List<AccountVO>voList=new ArrayList<>();
        for (AccountEntity entity:entities){
            AccountVO vo = mapper.map(entity, AccountVO.class);
            voList.add(vo);
        }
        voList.forEach(t-> System.out.println(t));
    }

    /**
     * 账户的总数量  成功
     */
    @Test
    public void count(){
        Long count = userInfoDao.countOfAccount();
        int i = count.intValue();
        System.out.println(count);
        System.out.println("转换后的int类型"+i);
    }

    /**
     * 账户分页信息的展示  成功
     */
    @Test
    public void page(){
        Long count = userInfoDao.countOfAccount();
        int sqlTotal = count.intValue();
        int pageCount= (int) Math.ceil(sqlTotal/2);//

        List<AccountEntity> entities = userInfoDao.getByPageNum(1, 2);

        List<AccountVO>voList=new ArrayList<>();
        for (AccountEntity entity:entities){
            AccountVO vo = mapper.map(entity, AccountVO.class);
            voList.add(vo);
        }
        PageControl<AccountVO>pageControl=new PageControl<>();
        Page<AccountVO> page = pageControl.setPage(1, pageCount, voList);
        System.out.println("头"+page.getStart());
        System.out.println("尾"+page.getEnd());
        System.out.println("页码"+page.getPageIndex());
        System.out.println("总数"+page.getPageTotal());
        page.getList().forEach(t-> System.out.println(t));
    }

    /**
     * 新增一个账户  成功
     */
    @Test
    public void saveOrUpdateToAdd(){
        AccountEntity entity=new AccountEntity();
        entity.setMobile("111111");
        entity.setEmail("111111@qq.com");
        entity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        entity.setGmtUpdate(new Timestamp(System.currentTimeMillis()));
        entity.setPassword(MD5Util.getMD5("1234"));
        entity.setType("1");//必填字段，不填就错了
        userInfoDao.saveOrUpdate(entity);
    }

    /**
     * 修改一个账户信息，成功
     */
    @Test
    public void saveOrUpdateToUpdate(){
        AccountEntity entity = userInfoDao.findByEmail("1694190210@qq.com");
        entity.setType("4");
        userInfoDao.saveOrUpdate(entity);
    }


    /**
     * 按照state寻找对应的state
     */
    @Test
    public void findByState(){
        List<AccountEntity> entities = userInfoDao.findAccountByState(1);
        for (AccountEntity entity:entities){
            AccountVO vo = mapper.map(entity, AccountVO.class);
            System.out.println("----"+vo);
        }
    }



}
