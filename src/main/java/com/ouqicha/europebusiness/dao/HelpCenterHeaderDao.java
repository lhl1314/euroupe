package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/16 0016
 * Time:8:45
 */
public interface HelpCenterHeaderDao {
    /**
     * 获取所有的帮助中心信息
     * @return
     */
    List<HelpCenterHeaderEntity>getAll();


    /**
     * 获取分页limit 语句
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<HelpCenterHeaderEntity>getByPage(int pageNum,int pageSize);
    /**
     * 数量
     * @return
     */
    Long HelpCount();

    /**
     * 删除一个标题内容
     * @param id
     */
    void deleteHelpHeaderCenter(int id);

    /**
     * 添加或修改
     * @param entity
     */
    void saveOrUpdata(HelpCenterHeaderEntity entity);


    /**
     * 获取一个
     * @param id
     * @return
     */
    HelpCenterHeaderEntity getOne(int id);
}
