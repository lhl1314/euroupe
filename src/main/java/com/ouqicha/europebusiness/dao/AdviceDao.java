package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.AdviceEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:16:44
 */
public interface AdviceDao {
    /**
     * 添加一条建议
     * @param adviceEntity
     */
    void addAdvice(AdviceEntity adviceEntity);

    /**
     * 获取一条建议
     * @param id
     * @return
     */
    AdviceEntity getOne(int id);

    /**
     * 获取limit数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AdviceEntity>getAdvicePage(int pageNum,int pageSize);

    /**
     * sql数量
     * @return
     */
    Long sqlCount();


    /**
     * 删除一条建议
     * @param id
     */
    void deleteAdvice(int id);
}
