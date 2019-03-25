package dao.back;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.util.Utils;
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
 * Date:2019/2/15 0015
 * Time:8:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CompanyDaoTest {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    Mapper mapper;
    @Test
    public void findLimit(){
        List<CompanyEntity> list = companyDao.getCompanyList(1, 2);
        List<CompanyVO>voList=new ArrayList<>();
        for (CompanyEntity companyEntity:list){
            CompanyVO vo = mapper.map(companyEntity, CompanyVO.class);
            voList.add(vo);
        }
        voList.forEach(t-> System.out.println(t));
    }

    /**
     * 添加一个公司的信息
     */
    @Test
    public void addCompany(){
        CompanyEntity companyEntity=new CompanyEntity();
        companyEntity.setName("中国达内培训机构");
        companyEntity.setMobile("1231231");
        companyEntity.setWebsite("www.baidu.com");
        companyDao.saveOrUpdateCompany(companyEntity);
    }

    /**
     * 查看公司的信息详情
     */
    @Test
    public void findOne(){
        CompanyEntity companyEntity = companyDao.findOneById(1);
        CompanyVO vo = mapper.map(companyEntity, CompanyVO.class);
        String s = vo.getProductImage();
        String[] strings = s.split("-");
        for (String imgSrc:strings){
            System.out.println("图片路径"+imgSrc);
        }
        System.out.println(vo);
    }

    /**
     * 修改一个公司的信息
     */
    @Test
    public void updateCompany(){
        CompanyEntity companyEntity = companyDao.findOneById(13);
        companyEntity.setAddress("中国浙江省温州鹿城区");
        companyDao.saveOrUpdateCompany(companyEntity);
    }

    /**
     * 删除公司的信息详情
     */
    @Test
    public void deleteOne(){
        CompanyEntity oneById = companyDao.findOneById(13);
        companyDao.deleteCompany(oneById);
    }


    /**
     * 企业信息
     */
    @Test
    public void countSql(){
        Long aLong = companyDao.companySqlCount();
        System.out.println(aLong);
    }


    @Test
    public void findLike(){
        List<CompanyEntity> entities = companyDao.findLikeCompany("公司");
        List<CompanyVO> voList = Utils.setDozerList(mapper, entities, CompanyVO.class);
        for (CompanyVO vo:voList){
            System.out.println(vo);
        }
    }

}
