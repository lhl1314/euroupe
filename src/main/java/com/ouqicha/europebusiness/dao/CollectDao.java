package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CollectEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:03
 */
public interface CollectDao {
    /**
     * 找到所有的收藏看看效果
     * @return
     */
    List<CollectEntity>getAll();


    List<CollectEntity>getPageCollectEntity(Integer countId,Integer page, Integer rows);

    /**
     * 添加或者修改收藏
     * @param collectEntity
     * @return
     */
    void saveOrUpdate(CollectEntity collectEntity);

    /**
     * 删除一个收藏
     * @param id
     * @return
     */
    void deleteCollectCompany(int id);

    /**
     * 找到一个唯一收藏
     * @param acId
     * @return
     */
    CollectEntity findOnly(String acId);


    /**
     * 找个某个账户的收藏个数
     * @param accountId
     * @return
     */
    Long collectCount(int accountId);
}
