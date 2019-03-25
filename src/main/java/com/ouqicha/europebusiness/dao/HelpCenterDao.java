package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:17:02
 */
public interface HelpCenterDao {
    /**
     * 获取帮助中心内容
     * @param titleSerialNumber
     * @return
     */
    List<HelpCenterEntity>getHelpCenterBySerialNumber(int titleSerialNumber);


    /**
     * 删除一个帮助内容
     * @param id
     */
    void deleteHelpCenter(int id);

    /**
     * 根据标题，删完关联信息
     * @param titleSerialNumber
     */
    void deleteHelpContentByHeader(int titleSerialNumber);

    /***
     * 添加一条帮助内容
     * @param helpCenterEntity
     */
    void saveOrUpdate(HelpCenterEntity helpCenterEntity);

}
